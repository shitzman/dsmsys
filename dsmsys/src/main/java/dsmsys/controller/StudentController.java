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
import dsmsys.pojo.Student;
import dsmsys.service.AdminService;
import dsmsys.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired
	AdminService adminService;
	
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
