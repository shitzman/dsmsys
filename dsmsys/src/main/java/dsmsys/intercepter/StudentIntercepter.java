package dsmsys.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import dsmsys.dao.StudentDao;
import dsmsys.pojo.Student;

public class StudentIntercepter implements HandlerInterceptor {

	@Autowired
	StudentDao studentDao;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("student") == null) {
			
			request.setAttribute("msg", "权限不够，请先登录学员账号");
			//response.sendRedirect(request.getContextPath()+"/admin/login");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		
		//获取最新账户信息存入session
		Student oldStu = (Student) request.getSession().getAttribute("student");
		Student student = studentDao.getStudentByMobileAndPwd(oldStu.getsMobile(), oldStu.getsPassword());
		request.getSession().setAttribute("student", student);
		return true;
	}

}
