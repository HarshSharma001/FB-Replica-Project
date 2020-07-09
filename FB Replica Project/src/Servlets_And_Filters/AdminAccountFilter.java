package Servlets_And_Filters;

import javax.servlet.http.*;

import Data_Processing_Units.AdminCredentials;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebFilter("/Admin.jsp")

public class AdminAccountFilter implements Filter
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException 
	{
		HttpServletRequest req1 = (HttpServletRequest) req;
		HttpServletResponse res1 = (HttpServletResponse) res;
		
		
		String uname = (String) req1.getParameter("uname");
		String pass = (String) req1.getParameter("pass");
		
		
		AdminCredentials ac = new AdminCredentials(uname, pass);
		
		
		if(ac.isStatus() == true)
		{
			fc.doFilter(req1, res1);
		}
		
		else if(ac.isStatus() == false)
		{
			res1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Ivalid Username/Password entered !");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
