package com.fpoly.Servlet.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Model.User;
import com.fpoly.ModelDAO.UserDAO;
import com.fpoly.Utils.SessionUtils;
import org.apache.commons.beanutils.BeanUtils;


@WebServlet({ "/UserManagementServlet", "/UserManagementServlet/create", "/UserManagementServlet/update",
	"/UserManagementServlet/delete", "/UserManagementServlet/reset", "/UserManagementServlet/edit",})
public class UsersManagementServlet extends HttpServlet {

	UserDAO usDao = new UserDAO(User.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		findAll(req, resp);
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.setAttribute("isLogin", false);
		}
		else {
			req.setAttribute("isLogin", true);
		}
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if(url.contains("edit")) {
			edit(req, resp);
			return;
		}
		if(url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if(url.contains("reset")) {
			reset(req, resp);
			return;
		}

		req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
	}
	
	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		req.setAttribute("user", user);
		findAll(req, resp);
		req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String id = req.getParameter("username");
		
		if (id == null) {
			req.setAttribute("error", "User id is required!");
			req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
			return;
		}
		try {
			
			UserDAO dao = new UserDAO(User.class);
			User user = dao.findById(id);
			
			if (user == null) {
				req.setAttribute("error", "User id not found!");
				req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
				return;
			}
			
			dao.delete(id);
			req.setAttribute("message", "user is deleted!");
			
			req.setAttribute("user", new User());
			findAll(req, resp);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("username");
		
		if (id == null) {
			req.setAttribute("error", "Video id is required!");
			req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
			return;
		}
		try {
			
			UserDAO dao = new UserDAO(User.class);
			User user = dao.findById(id);
			
			req.setAttribute("user", user);
			findAll(req, resp);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		
        try {
        	
			UserDAO dao = new UserDAO(User.class);
			
			List<User> list = dao.findAll();
			
			req.setAttribute("listUser", list);
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.setAttribute("isLogin", false);
		}
		else {
			req.setAttribute("isLogin", true);
		}
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if(url.contains("create")) {
			create(req, resp);
			return;
		}
		if(url.contains("delete")) {
			delete(req, resp);
			return;
		}
		if(url.contains("update")) {
			update(req, resp);
			return;
		}
		if(url.contains("reset")) {
			reset(req, resp);
			return;
		}
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		
        try {
			BeanUtils.populate(user, req.getParameterMap());
        	
			UserDAO dao = new UserDAO(User.class);
			User oldUser = dao.findById(user.getUserName());

			dao.update(user);
			
			req.setAttribute("user", user);
			req.setAttribute("message", "User is update!");
			
			findAll(req, resp);
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
						
			UserDAO dao = new UserDAO(User.class);
			dao.insert(user);
			
			req.setAttribute("user", user);
			req.setAttribute("message", "User is inserted! " );
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/Admin_Edit_User.jsp").forward(req,resp);
	}
		
	

}
