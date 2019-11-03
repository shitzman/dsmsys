package dsmsys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dsmsys.pojo.Student;
import dsmsys.service.AdminService;
import dsmsys.service.StudentService;

@Controller()
@RequestMapping(value = "admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	StudentService studentService;
	
	//��ѯ���������뵫δ������ѧԱ
	@RequestMapping(value = "/showallstubyaccount", method = RequestMethod.GET)
	public String ShowAllStuByAccount(Model model) {
		List<Student> stuListByAcc = studentService.getAllStudentByAccount(0);//account=0Ϊδ���ѧԱ
		model.addAttribute("stuListAcc", stuListByAcc);
		return "admin/allStuListByacc";
	} 
	
	//��ѯ����ѧԱ
	@RequestMapping(value = "/showallstu", method = RequestMethod.GET)
	public String showAllStu(Model model) {
		
		List<Student> stuList = studentService.getAllStudent();
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
