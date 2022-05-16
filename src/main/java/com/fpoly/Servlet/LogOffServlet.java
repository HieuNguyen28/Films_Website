package com.fpoly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Utils.CookieUtils;
import com.fpoly.Utils.SessionUtils;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/LogoffServlet")
public class LogOffServlet extends HttpServlet {
       
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, resp);
		SessionUtils.invalidate(req);
		
		req.setAttribute("isLogin", false);
		req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
	}

}
