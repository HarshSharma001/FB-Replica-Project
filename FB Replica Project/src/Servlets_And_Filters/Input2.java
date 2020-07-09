package Servlets_And_Filters;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Data_Processing_Units.SendAutomatedEmail;

@WebServlet("/Input2")

public class Input2 extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		String email = (String) req.getParameter("email");

		
		if(email.length()<=32)
		{
			SendAutomatedEmail se = new SendAutomatedEmail();

			se.sendEmail(email);
			
			String code = se.getCode();
			
			HttpSession session = req.getSession();
			
			session.setAttribute("vcode", code);
			session.setAttribute("email", email);
			
			
			res.sendRedirect("VerifyEmail1.jsp");
		}
		
		
		else 
		{
			res.sendError(HttpServletResponse.SC_LENGTH_REQUIRED, "You've exceeded the limit of letters/characters as per rules ! ");
		}
		
		

	}
}
