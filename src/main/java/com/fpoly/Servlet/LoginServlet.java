package com.fpoly.Servlet;

import com.fpoly.Items.LoginForm;
import com.fpoly.Model.User;
import com.fpoly.ModelDAO.UserDAO;
import com.fpoly.Utils.CookieUtils;
import com.fpoly.Utils.SessionUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;


@WebServlet(name="Login", value ="/LoginServlet")
public class LoginServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		 String username = CookieUtils.get("username", req);

		if (username !=null){
			SessionUtils.add(req, "username", username);
		}
		req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm loginForm = new LoginForm();
			BeanUtils.populate(loginForm, req.getParameterMap());
			UserDAO userDAO = new UserDAO(User.class);

			User user_login = userDAO.findById(loginForm.getUsername());
			if(user_login!= null && user_login.getPassword().equals(loginForm.getPassword())) {
				SessionUtils.add(req, "username", user_login.getUserName());
				if(loginForm.isRemember()) {
					CookieUtils.add("username", user_login.getUserName(), 24, resp);
				}else {
					CookieUtils.add("username", user_login.getUserName(), 0, resp);
				}
				req.setAttribute("isLogin", true);
				req.setAttribute("name", user_login.getFullName());
				if(!user_login.isAdmin()) {
					req.getRequestDispatcher("/Homepage").forward(req, resp);
				}
				else {
					this.createSession(req, user_login);
//					resp.sendRedirect("http://localhost:8080/PS15722_NguyenChiHieu_ASM_war_exploded/VideosManagement");
					req.getRequestDispatcher("/Admin/VideosManagement").forward(req, resp);
				}
				return;
			}
			req.setAttribute("error", "Invalid Username or Password");
			req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
	}
	
	private void createSession (HttpServletRequest req, User user) {
		HttpSession session = req.getSession();
		session.setAttribute("userSession", user);
	}

}
