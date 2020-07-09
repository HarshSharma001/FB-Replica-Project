package Servlets_And_Filters;

import javax.servlet.http.*;



import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebFilter("/Input2")

public class ForgotAccountFilter implements Filter
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
		
		
		String email = (String) req1.getParameter("email");
		
		if(email.trim().equals(""))
		{
			res1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Ivalid input entered, kindly fill the fields properly !");
		}
		
		else
		{
			fc.doFilter(req1, res1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
