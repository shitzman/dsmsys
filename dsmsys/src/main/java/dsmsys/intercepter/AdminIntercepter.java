package dsmsys.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;


public class AdminIntercepter implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("admin") == null) {
			
			request.setAttribute("msg", "权限不够，请先登录管理员账号");
			//response.sendRedirect(request.getContextPath()+"/admin/login");
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}

		return true;
	}

}
