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

//�Դ˿������µ�����·������AdminIntercepter������֤
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
	
	//Ϊ������ӻ������������
	@RequestMapping(value="/linktandc", method=RequestMethod.POST)
	public String linkTeahcerAndCar(String cId,Integer tId, Model model){
	
		teacherService.updateCIdByTId(cId, tId);
		
		
		model.addAttribute("tId", tId);
		return "redirect:showstubyt";
	}
	
	//��ѯ��������ѧԱ
	@RequestMapping(value="/showstubyt",method=RequestMethod.GET)
	public String getStudentByTId(Integer tId, Model model){
		List<Student> stuList = studentService.getStudentByTId(tId);
		Teacher teacher = teacherService.getTeacherById(tId);
		Car car = carService.getCarByCId(teacher.getcId());
		List<String> carIdList = carService.getAllCarIdByStatus(1);//��ȡ���п��ó��ƺţ�����ǰ��ѡ��
		model.addAttribute("carIdList", carIdList);
		model.addAttribute("stuList", stuList);
		model.addAttribute("teacher", teacher);
		model.addAttribute("car", car);
		return "teacher/showStuByt";
	}

	//����Ա����ѧԱԤԼ���ԣ�ͬ�⣩
	@RequestMapping(value = "/ratifyexamyes", method = RequestMethod.GET)
	public String ratifyExamYes(String sId,String eId,Model model) {
		adminService.ratifyExamYes(Integer.parseInt(sId), Integer.parseInt(eId));
		model.addAttribute("msg", "����׼��ѧԱ������");
		return "admin/ratifyExamAfter";
	}
	
	//����Ա����ѧԱԤԼ���ԣ��ܾ���
	@RequestMapping(value = "ratifyexamno", method = RequestMethod.GET)
	public String ratifyExamNo(String sId, Model model) {
		adminService.ratifyExamNo(Integer.parseInt(sId));
		model.addAttribute("msg", "�Ѿܾ���ѧԱ������");
		return "admin/ratifyExamAfter";
	}
	
	//����������Ϣ
	@RequestMapping(value="/addexammsg", method=RequestMethod.POST)
	public String addExammsg(Exammsg exammsg){
		exammsg.seteAlrNum(0);//��ʼ���ѱ�������Ϊ0
		exammsgService.insertExamMsg(exammsg);
		//�洢
		return "redirect:showexammsg";
	}
	
	//������ӿ�����Ϣ����
	@RequestMapping(value="/addexammsg", method=RequestMethod.GET)
	public String toAddExammsg(){
		
		return "admin/addExammsg";
	}
	
	//Ϊ����Ա��ʾ�����������п�����Ϣ
	@RequestMapping(value="/showexammsg", method=RequestMethod.GET)
	public String showExammsg(HttpSession session,Model model){
		List<Exammsg> examList = exammsgService.getAllExammsg();
		model.addAttribute("examList", examList);
		return "student/showExammsg";
	}
	
	//����ѧԱ������ϢԤԼ�б����
	@RequestMapping(value="/showexamorder",method=RequestMethod.GET)
	public String toShowExamOrder(Model model){
		Map<Student,Integer> orderList = examOrderServie.getAllOrderIdAndStudentMap();
		model.addAttribute("orderList", orderList);
		return "admin/showExamOrder";
	}
	
	//����ѧԱ��ѧ
	@RequestMapping(value = "/ratifystu", method = RequestMethod.GET)
	public String ratifyStu(String sId, Model model) {
		Student student = new Student();
		
		student.setsId(Integer.parseInt(sId));
		student.setsAccount(1);//�޸�ѧԱ�˻�״̬�ֶ�Ϊ���ã�
		student.setsCurrent(1);//�޸ĵ�ǰѧԱĬ�Ͽ�ĿΪ��Ŀһ��
		student.setsRegTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//����ѧԱ��ѧʱ��Ϊ��ǰʱ��
		if(studentService.ratifyStu(student)>0) {
			student = studentService.getStudentBySid(Integer.parseInt(sId));//�����ݿ�ȡ��ѧԱ������Ϣ
			model.addAttribute("student", student);//�޸ĳɹ�����Ŀ����洫��һ��student����
		}
		
		return "admin/ratifyStuAfter";
	}
	
	//��ѯ���������뵫δ������ѧԱ
	@RequestMapping(value = "/showallstubyaccount", method = RequestMethod.GET)
	public String ShowAllStuByAccount(Model model) {
		List<Student> stuListByAcc = studentService.getAllStudentByAccount(0);//account=0Ϊδ���ѧԱ
		model.addAttribute("stuListAcc", stuListByAcc);
		return "admin/allStuListByacc";
	} 
	
	//��ѯ����������ѧԱ
	@RequestMapping(value = "/showallstu", method = RequestMethod.GET)
	public String showAllStu(Model model) {
		
		List<Student> stuList = studentService.getAllStudentByAccount(1);//account=1Ϊ�����ѧԱ
		model.addAttribute("stuList", stuList);
		return "admin/allStuList";
	}
	
	//����������
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String toManage(HttpSession session, Model model) {
		
		return "admin/manage";
	}
	
	//�˳�
	@RequestMapping(value = "adminlogout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/index.jsp";
	}
	
	
}
