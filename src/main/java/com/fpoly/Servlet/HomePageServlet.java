package com.fpoly.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.VideoDAO;
import com.fpoly.Utils.SessionUtils;


@WebServlet("/Homepage")
public class HomePageServlet extends HttpServlet {

 		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
		String username = SessionUtils.getLoginedUsername(req);
		if(username == null) {
			req.setAttribute("isLogin", false);
		}
		else {
			req.setAttribute("isLogin", true);
		}
		try {
			VideoDAO dao = new VideoDAO(Video.class);
			List<Video> list = new VideoDAO(Video.class).loadVideosActive(true);
			req.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/HomePage.jsp").forward(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
