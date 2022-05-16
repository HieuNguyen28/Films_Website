package com.fpoly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Items.Email;
import com.fpoly.Model.User;
import com.fpoly.ModelDAO.UserDAO;
import com.fpoly.Utils.EmailUtils;


/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/User_ForgotPassword.jsp").forward(req,resp );
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String username = req.getParameter("username");
			
			UserDAO dao = new UserDAO(User.class);
			User user = dao.findByUsernameAndEmail(username, emailAddress);
			
			if (user == null) {
				req.setAttribute("error", "Username or email are incorrect");
			}else {
				Email email = new Email();
				email.setFrom("socola2067@gmail.com");
				email.setFromPassword("mbcyrwhfbwwztwps");
				email.setTo(emailAddress);
				email.setSubbjet("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are used the forgot password function. <br> ");
				sb.append("Your password is <b> ").append(user.getPassword()).append("</b> <br>");
				sb.append("Regards. <br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				req.setAttribute("message", "Email sent to the email Address. "
						+ "Please check and get your password");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/User_ForgotPassword.jsp").forward(req,resp );
	}

}
