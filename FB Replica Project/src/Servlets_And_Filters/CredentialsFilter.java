package Servlets_And_Filters;

import javax.servlet.http.*;

import Data_Processing_Units.DBCredentials;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebFilter("/Welcome.jsp")

public class CredentialsFilter implements Filter
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
		
		HttpSession session = req1.getSession();
		
		String username = (String) session.getAttribute("uname");
		String password = (String) session.getAttribute("pass");
		
		DBCredentials dbc = new DBCredentials(username, password);
		
		if(dbc.isStatus() == true)
		{
			fc.doFilter(req1, res1);
		}
		
		else
		{
			res1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Username or Password entered !");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
