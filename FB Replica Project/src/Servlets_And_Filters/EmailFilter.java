package Servlets_And_Filters;

import javax.servlet.http.*;

import Data_Processing_Units.SaveUserAccount;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebFilter("/Acknowledgement.jsp")

public class EmailFilter implements Filter
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
		
		String fname = (String) session.getAttribute("fname");
		String lname = (String) session.getAttribute("lname");
		String email = (String) session.getAttribute("email");
		String uname = (String) session.getAttribute("uname");
		String pass = (String) session.getAttribute("pass");
		
		
		String generatedCode = (String) session.getAttribute("vcode");
		
		String userEnterdCode = req1.getParameter("vcode").toString();
		
		
		if(userEnterdCode.equals(generatedCode))
		{
			SaveUserAccount sua = new SaveUserAccount(fname, lname, email, uname, pass);
			fc.doFilter(req1, res1);
		}
		
		if(!userEnterdCode.equals(generatedCode))
		{
			res1.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Ivalid verification code entered !");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
