package Servlets_And_Filters;

import javax.servlet.http.*;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebFilter("/Input1")

public class InputFilter implements Filter
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
		
		String fname = (String) req1.getParameter("fname");
		String lname = (String) req1.getParameter("lname");
		String email = (String) req1.getParameter("email");
		String uname = (String) req1.getParameter("uname");
		String pass = (String) req1.getParameter("pass");

		if(fname.trim().equals("") || lname.trim().equals("") || email.trim().equals("") || uname.trim().equals("") || pass.trim().equals(""))
		{
			res1.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid inputs entered, kindly fill all the feilds correctly ! ");
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
