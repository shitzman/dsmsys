package dsmsys.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dsmsys.pojo.Admin;
import dsmsys.pojo.Exammsg;
import dsmsys.pojo.Student;
import dsmsys.service.AdminService;
import dsmsys.service.ExammsgService;
import dsmsys.service.RemarkService;
import dsmsys.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	AdminService adminService;
	@Autowired
	RemarkService remarkService;
	@Autowired
	ExammsgService exammsgService;
	
	//ѧԱ��ѯ��ԤԼ������Ϣ
	@RequestMapping(value="showexamorder", method=RequestMethod.GET)
	public String showExamOrder(HttpSession session, Model model){
		Student student = (Student) session.getAttribute("student");
		String eId = remarkService.selecteIdBysIdAndrStatus(student.getsId(), 0);//����׼
		model.addAttribute("msg", "���ѳɹ��������¿��ԣ�������׼������");
		if(eId == "" || eId == null){
			model.addAttribute("msg", "�㻹δԤԼ�κο���");
			return "/student/showExamOrder";
		}
		Exammsg exammsg = exammsgService.getExammsgByeId(Integer.parseInt(eId));
		model.addAttribute("exammsg", exammsg);
		return "/student/showExamOrder";
	}
	
	//ѧԱԤԼ����
	@RequestMapping(value = "addexamorder", method = RequestMethod.GET)
	public String addExamOrder(String eId, HttpSession session,Model model) {
		Student student = (Student) session.getAttribute("student");
		if(studentService.addExamOrder(student.getsId(), 1, Integer.parseInt(eId))>0) {
			student.setsStatus(1);
			session.setAttribute("session", student);//����session�е��û�����
			return "redirect:/exam/showexammsg";
		}
		model.addAttribute("msg", "ԤԼʧ��");
		return "redirect:/exam/showexammsg";
	}
	
	//�˳�
	@RequestMapping(value = "stulogout", method = RequestMethod.GET)
	public String stuLogout(HttpSession session) {
		session.removeAttribute("student");
		return "redirect:/index.jsp";
	}

	// �����¼����
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(HttpSession session, Model model) {

		if (session.getAttribute("admin") != null) {
			model.addAttribute("msg", "�����˳���¼");
			return "admin/manage";
		} else if (session.getAttribute("student") != null) {
			model.addAttribute("msg", "�����˳���¼");
			return "stuDetails";
		}

		return "login";
	}

	// ��¼����
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String mobile, String password, String type, HttpSession session, Model model,
			HttpServletResponse resp) {
		if (type.equals("0")) {
			Admin admin = adminService.getAdminByMobileAndPwd(mobile, password);
			if (admin != null) {
				session.setAttribute("admin", admin);
				session.setMaxInactiveInterval(60 * 30);
				Cookie cookie = new Cookie("JSESSIONID", session.getId());
				cookie.setMaxAge(60 * 30);
				cookie.setPath("/dsmsys");
				resp.addCookie(cookie);

				model.addAttribute("admin", admin);
				return "admin/manage";
			} else {
				model.addAttribute("msg", "��¼ʧ�ܣ���ע��ѡ���¼���");
				model.addAttribute("mobile", mobile);
				return "login";
			}
		}

		Student student = studentService.getStudentByMobileAndPwd(mobile, password);
		if (student != null) {
			session.setAttribute("student", student);
			session.setMaxInactiveInterval(60 * 30);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60 * 30);
			cookie.setPath("/dsmsys");
			resp.addCookie(cookie);

			model.addAttribute("student", student);
			return "stuDetails";
		}

		model.addAttribute("msg", "��¼ʧ�ܣ���ע��ѡ���¼���");
		model.addAttribute("mobile", mobile);
		return "login";
	}

	// ��ת��ѧԱ�������
	@RequestMapping(value = "/regstudent", method = RequestMethod.GET)
	public String toRegStudent() {

		return "regStudent";
	}

	// ѧԱ����
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String RegStudent(Student student, Model model) {
		
		//����û��ֻ����Ƿ��ѱ�ע��
		if(studentService.checkSMobile(student.getsMobile())>0) {
			model.addAttribute("msg", "���ֻ����ѱ�ע�ᣬ�����¼������");
			return "regStudent";
		}

		// ��ʼ��ѧԱ״̬
		student.setsCurrent(0);// ���õ�ǰ��ĿΪ0
		student.setsAccount(0);// ���õ�ǰ�˻�״̬Ϊ0��δ������Ա�����������ã�
		student.settId(0);// ���ý���ԱidΪ0
		student.setsStatus(0);// ���õ�ǰ����״̬Ϊ0
		// ��ѧԱ��Ϣд�����ݿ�
		if (studentService.addStudent(student) <= 0) {
			model.addAttribute("msg", "����ʧ�ܣ�����ϵ����Ա��ѯ");
			return "regStudent";
		}
		model.addAttribute("student", student);
		model.addAttribute("msg", "�������ύ�������ĵȴ�����Ա����");
		return "stuDetails";
	}

}
