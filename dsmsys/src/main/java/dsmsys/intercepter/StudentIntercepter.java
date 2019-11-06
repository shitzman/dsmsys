package dsmsys.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class StudentIntercepter implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("student") == null) {
			
			request.setAttribute("msg", "Ȩ�޲��������ȵ�¼ѧԱ�˺�");
			//response.sendRedirect(request.getContextPath()+"/admin/login");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}

		return true;
	}

}
