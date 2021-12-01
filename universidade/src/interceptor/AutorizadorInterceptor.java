package interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter 
{	
	public boolean preHandler(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String uri= request.getRequestURI();
		if(uri.endsWith("loginForm") || uri.endsWith("efetuaLogin") || uri.contains("resources"))
		{
			return true;
		}
		if(request.getSession().getAttribute("usuarioLogado")!=null)
		{
			return true;
		}
		response.sendRedirect("loginForm");
		return false;
	}
}
