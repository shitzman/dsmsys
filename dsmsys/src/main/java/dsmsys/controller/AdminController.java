package dsmsys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dsmsys.pojo.Car;
import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Student;
import dsmsys.pojo.Teacher;
import dsmsys.service.AdminService;
import dsmsys.service.CarService;
import dsmsys.service.ExamOrderService;
import dsmsys.service.ExammsgService;
import dsmsys.service.StudentService;
import dsmsys.service.TeacherService;

//对此控制器下的所有路径进行AdminIntercepter过滤验证
@Controller()
@RequestMapping(value = "admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	StudentService studentService;
	@Autowired
	ExamOrderService examOrderServie;
	@Autowired
	ExammsgService exammsgService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CarService carService;
	
	//为教练添加或更改所属车辆
	@RequestMapping(value="/linktandc", method=RequestMethod.POST)
	public String linkTeahcerAndCar(String cId,Integer tId, Model model){
	
		teacherService.updateCIdByTId(cId, tId);
		
		
		model.addAttribute("tId", tId);
		return "redirect:showstubyt";
	}
	
	//查询教练所带学员
	@RequestMapping(value="/showstubyt",method=RequestMethod.GET)
	public String getStudentByTId(Integer tId, Model model){
		List<Student> stuList = studentService.getStudentByTId(tId);
		Teacher teacher = teacherService.getTeacherById(tId);
		Car car = carService.getCarByCId(teacher.getcId());
		List<String> carIdList = carService.getAllCarIdByStatus(1);//获取所有可用车牌号，用于前端选择
		model.addAttribute("carIdList", carIdList);
		model.addAttribute("stuList", stuList);
		model.addAttribute("teacher", teacher);
		model.addAttribute("car", car);
		return "teacher/showStuByt";
	}

	//管理员审批学员预约考试（同意）
	@RequestMapping(value = "/ratifyexamyes", method = RequestMethod.GET)
	public String ratifyExamYes(String sId,String eId,Model model) {
		adminService.ratifyExamYes(Integer.parseInt(sId), Integer.parseInt(eId));
		model.addAttribute("msg", "已批准该学员的申请");
		return "admin/ratifyExamAfter";
	}
	
	//管理员审批学员预约考试（拒绝）
	@RequestMapping(value = "ratifyexamno", method = RequestMethod.GET)
	public String ratifyExamNo(String sId, Model model) {
		adminService.ratifyExamNo(Integer.parseInt(sId));
		model.addAttribute("msg", "已拒绝该学员的申请");
		return "admin/ratifyExamAfter";
	}
	
	//发布考试信息
	@RequestMapping(value="/addexammsg", method=RequestMethod.POST)
	public String addExammsg(Exammsg exammsg){
		exammsg.seteAlrNum(0);//初始化已报考人数为0
		exammsgService.insertExamMsg(exammsg);
		//存储
		return "redirect:showexammsg";
	}
	
	//导向添加考试信息界面
	@RequestMapping(value="/addexammsg", method=RequestMethod.GET)
	public String toAddExammsg(){
		
		return "admin/addExammsg";
	}
	
	//为管理员显示发布过的所有考试信息
	@RequestMapping(value="/showexammsg", method=RequestMethod.GET)
	public String showExammsg(HttpSession session,Model model){
		List<Exammsg> examList = exammsgService.getAllExammsg();
		model.addAttribute("examList", examList);
		return "student/showExammsg";
	}
	
	//导向学员考试信息预约列表界面
	@RequestMapping(value="/showexamorder",method=RequestMethod.GET)
	public String toShowExamOrder(Model model){
		Map<Student,Integer> orderList = examOrderServie.getAllOrderIdAndStudentMap();
		model.addAttribute("orderList", orderList);
		return "admin/showExamOrder";
	}
	
	//审批学员入学
	@RequestMapping(value = "/ratifystu", method = RequestMethod.GET)
	public String ratifyStu(String sId, Model model) {
		Student student = new Student();
		
		student.setsId(Integer.parseInt(sId));
		student.setsAccount(1);//修改学员账户状态字段为可用；
		student.setsCurrent(1);//修改当前学员默认科目为科目一；
		student.setsRegTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//设置学员入学时间为当前时间
		if(studentService.ratifyStu(student)>0) {
			student = studentService.getStudentBySid(Integer.parseInt(sId));//从数据库取出学员完整信息
			model.addAttribute("student", student);//修改成功会向目标界面传递一个student对象；
		}
		
		return "admin/ratifyStuAfter";
	}
	
	//查询所有已申请但未审批的学员
	@RequestMapping(value = "/showallstubyaccount", method = RequestMethod.GET)
	public String ShowAllStuByAccount(Model model) {
		List<Student> stuListByAcc = studentService.getAllStudentByAccount(0);//account=0为未审核学员
		model.addAttribute("stuListAcc", stuListByAcc);
		return "admin/allStuListByacc";
	} 
	
	//查询所有已审批学员
	@RequestMapping(value = "/showallstu", method = RequestMethod.GET)
	public String showAllStu(Model model) {
		
		List<Student> stuList = studentService.getAllStudentByAccount(1);//account=1为已审核学员
		model.addAttribute("stuList", stuList);
		return "admin/allStuList";
	}
	
	//导向管理界面
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String toManage(HttpSession session, Model model) {
		
		return "admin/manage";
	}
	
	//退出
	@RequestMapping(value = "adminlogout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/index.jsp";
	}
	
	
}
