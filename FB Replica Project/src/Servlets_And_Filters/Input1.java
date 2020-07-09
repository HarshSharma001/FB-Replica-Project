package Servlets_And_Filters;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Data_Processing_Units.SendAutomatedEmail;

@WebServlet("/Input1")

public class Input1 extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		String fname = (String) req.getParameter("fname");
		String lname = (String) req.getParameter("lname");
		String email = (String) req.getParameter("email");
		String uname = (String) req.getParameter("uname");
		String pass = (String) req.getParameter("pass");

		
		if(fname.length()<=15 && lname.length()<=20 && email.length()<=32 && uname.length()<=12 && pass.length()<=20 )
		{
			SendAutomatedEmail se = new SendAutomatedEmail();

			se.sendEmail(email);
			
			String code = se.getCode();
			
			HttpSession session = req.getSession();
			
			session.setAttribute("vcode", code);
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			session.setAttribute("email", email);
			session.setAttribute("uname", uname);
			session.setAttribute("pass", pass);

			
			res.sendRedirect("VerifyEmail.jsp");
		}
		
		
		else 
		{
			res.sendError(HttpServletResponse.SC_LENGTH_REQUIRED, "You've exceeded the limit of letters/characters as per rules ! ");
		}
		
		

	}
}
