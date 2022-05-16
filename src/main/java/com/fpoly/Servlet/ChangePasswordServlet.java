package com.fpoly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Items.ChangePasswordForm;
import com.fpoly.Model.User;
import com.fpoly.ModelDAO.UserDAO;
import com.fpoly.Utils.SessionUtils;
import org.apache.commons.beanutils.BeanUtils;



/**
 * Servlet implementation class ChangepasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = SessionUtils.getLoginedUsername(req);
		
		if( username == null) {
			req.getRequestDispatcher("/LoginServlet").forward(req, resp);
			req.setAttribute("isLogin", false);
			return;
		}
		req.setAttribute("username", username);
		req.getRequestDispatcher("/views/User_ChangePassword.jsp").forward(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(req);
			ChangePasswordForm form = new ChangePasswordForm();
			
			BeanUtils.populate(form, req.getParameterMap());
			req.setAttribute("username", username);
			
            if (!form.getConfirmPassword().equals(form.getPassword())) {
				req.setAttribute("error", "New password and new confirm password are not identical");
			}else {
				UserDAO dao = new UserDAO(User.class);
				dao.changePassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
				req.setAttribute("message", "Password has been changed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("isLogin", true);
		req.getRequestDispatcher("/views/User_ChangePassword.jsp").forward(req,resp);
	}

}
