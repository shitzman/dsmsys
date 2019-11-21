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
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dsmsys.pojo.Car;
import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Remark;
import dsmsys.pojo.Student;
import dsmsys.pojo.Teacher;
import dsmsys.service.AdminService;
import dsmsys.service.CarService;
import dsmsys.service.ExamOrderService;
import dsmsys.service.ExammsgService;
import dsmsys.service.RemarkService;
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
	@Autowired
	RemarkService remarkService;
	
	//解除学员教练关系
	@RequestMapping(value="relievetcandstu", method=RequestMethod.GET)
	public String relieveTeacherAndStu(String sId, String tId, Model model){
		studentService.updatetIdNullBysId(Integer.parseInt(sId));
		model.addAttribute("tId", tId);
		return "redirect:showstubyt";
	}
	
	//修改车辆信息（是否可用状态码，与备注信息）
	@RequestMapping(value = "toupdatecarstatus", method = RequestMethod.GET)
	public String toUpdateCarStatus(String cFlag,Model model) {
		model.addAttribute("cFlag", cFlag);
		return "admin/updateCarStatus";
	}
	
	@RequestMapping(value = "updatecarstatus", method = RequestMethod.POST)
	public String updateCarStatus(Car car, Model model) {
		if(carService.updatecStatusAndcRemarkBycFlag(car)>0) {
			model.addAttribute("msg", "修改成功车辆信息【"+car.getcFlag()+"】成功");
		}else {
			model.addAttribute("msg", "修改成功车辆信息【"+car.getcFlag()+"】失败");
		}
		List<Car> carList = carService.getAllCar();
		model.addAttribute("carList", carList);
		return "showAllCar";
	}
	
	
	//录入学员考试记录
	@RequestMapping(value = "updateremark", method = RequestMethod.POST)
	public String updateRemark(Remark remark, Model model) {
		
		if(studentService.getStudentBySid(remark.getsId()).getsStatus()!=2) {
			model.addAttribute("warnings", "请不要重复提交数据！");
			return "admin/updateRemarkAfter";
		}
		
		if(remark.getrScore()<90) {		//低于90分为不及格，将学员的当前考试记录设为2：挂科
			remark.setrStatus(2);
			adminService.changeRemarkAndStuFail(remark);//更新当前考试记录，并改变学员考试状态
			Student student = studentService.getStudentBySid(remark.getsId());
			model.addAttribute("msg", "该学员此次考试信息已录入系统，详情信息如下");
			model.addAttribute("remark", remark);
			model.addAttribute("student", student);
			return "admin/updateRemarkAfter";
		}
		
		remark.setrStatus(1);//否则将学员的当前考试记录设为1：过关
		int sSubject = adminService.changeRemarkAndStuPass(remark);//返回值为更新后的学员所处科目
		
		//最后一关
		if(sSubject>4) {	//如果学员当前所处科目大于4，则通知其来校拿证
			Student stuEnd = studentService.getStudentBySid(remark.getsId());
			model.addAttribute("msg", "学员已通过所有考试，快通知学员来拿证吧！");
			model.addAttribute("stuEnd", stuEnd);			//标识
			return "admin/updateRemarkAfter";
		}
		
		//普通过关
		Student stu = studentService.getStudentBySid(remark.getsId());
		model.addAttribute("msg1", "该学员通过此次考试信息已录入系统，详情信息如下");
		model.addAttribute("remark", remark);
		model.addAttribute("stu", stu);				//标识
		return "admin/updateRemarkAfter";
	}
	
	//查询所有待考试状态的记录
	@RequestMapping(value = "showeremark0", method = RequestMethod.GET)
	public String showExamRemarkByStatus(Model model) {
		List<Remark> reList = remarkService.getRemarkByStatus(0);//status=0,为待考状态
		model.addAttribute("reList", reList);
		return "admin/showExamRemarkByS0";
	}
	
	//为学员分配教练
	@RequestMapping(value = "linkstuandt", method = RequestMethod.GET)
	public String linkStudentAndTeacher(Integer sId, Integer tId, Model model) {
		studentService.updatetIdBysId(tId, sId);
		return "redirect:showallstu";
	}
	
	//为教练添加或更改所属车辆
	@RequestMapping(value="/linktandc", method=RequestMethod.POST)
	public String linkTeahcerAndCar(String cId,Integer tId, Model model){
	
		teacherService.updateCIdByTId(cId, tId);
		model.addAttribute("tId", tId);
		return "redirect:showstubyt";
	}
	
	//查询教练所带学员，教练详情
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
	public String showAllStu(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model) {
		
		PageHelper.startPage(pn, 3);
		List<Student> stuList = studentService.getAllStudentByAccount(1);//account=1为已审核学员
		
		PageInfo<Student> pageStuList = new PageInfo<Student>(stuList);
		model.addAttribute("pageStuList", pageStuList);//已在Studnet中绑定学员当前科目可选择教练列表
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
