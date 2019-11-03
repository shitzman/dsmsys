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
	
	//退出
	@RequestMapping(value = "stulogout", method = RequestMethod.GET)
	public String stuLogout(HttpSession session) {
		session.removeAttribute("student");
		return "redirect:/index.jsp";
	}

	// 导向登录界面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(HttpSession session, Model model) {

		if (session.getAttribute("admin") != null) {
			model.addAttribute("msg", "请先退出登录");
			return "admin/manage";
		} else if (session.getAttribute("student") != null) {
			model.addAttribute("msg", "请先退出登录");
			return "stuDetails";
		}

		return "login";
	}

	// 登录操作
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
				model.addAttribute("msg", "登录失败，请注意选择登录身份");
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

		model.addAttribute("msg", "登录失败，请注意选择登录身份");
		model.addAttribute("mobile", mobile);
		return "login";
	}

	// 跳转至学员申请界面
	@RequestMapping(value = "/regstudent", method = RequestMethod.GET)
	public String toRegStudent() {

		return "regStudent";
	}

	// 学员申请
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String RegStudent(Student student, Model model) {

		// 初始化学员状态
		student.setsCurrent(0);// 设置当前科目为0
		student.setsAccount(0);// 设置当前账户状态为0（未经管理员审批，不可用）
		student.settId(0);// 设置教练员id为0
		student.setsStatus(0);// 设置当前考试状态为0

		// 将学员信息写入数据库
		if (studentService.addStudent(student) <= 0) {
			model.addAttribute("msg", "申请失败，请联系管理员咨询");
			return "regStudent";
		}
		model.addAttribute("student", student);
		model.addAttribute("msg", "申请已提交，请耐心等待管理员审批");
		return "stuDetails";
	}

}
