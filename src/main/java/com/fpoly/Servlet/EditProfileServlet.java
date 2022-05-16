package com.fpoly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Model.User;
import com.fpoly.ModelDAO.UserDAO;
import com.fpoly.Utils.SessionUtils;
import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class EditprofileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username = SessionUtils.getLoginedUsername(req);
		System.out.println(username);
		if(username == null) {
			req.getRequestDispatcher("/LoginServlet").forward(req, resp);
			req.setAttribute("isLogin", false);
			return;
		}
		try {
			UserDAO dao = new UserDAO(User.class);
			User user = dao.findById(username);
			
			req.setAttribute("user", user);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("isLogin", true);
		req.getRequestDispatcher("/views/User_Profile.jsp").forward(req,resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			User user = new User();
			BeanUtils.populate(user, req.getParameterMap());
			String username = SessionUtils.getLoginedUsername(req);
			
			UserDAO dao = new UserDAO(User.class);
			User oldUser = dao.findById(username);
			
			user.setAdmin(oldUser.isAdmin());
			dao.update(user);
			req.setAttribute("Message", "User profile updated!!!");
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("isLogin", true);
		req.getRequestDispatcher("/views/User_Profile.jsp").forward(req,resp);
	}

}
