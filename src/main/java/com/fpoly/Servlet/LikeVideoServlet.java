package com.fpoly.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fpoly.Model.Favorite;
import com.fpoly.Model.User;
import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.FavoriteDAO;
import com.fpoly.ModelDAO.UserDAO;
import com.fpoly.ModelDAO.VideoDAO;
import com.fpoly.Utils.SessionUtils;


/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/LikeVideo")
public class LikeVideoServlet extends HttpServlet {

       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(!SessionUtils.isLogin(req)) {
			req.getRequestDispatcher("/LoginServlet").forward(req, resp);
			return;
		}
		String page  = req.getParameter("page");
		String videoId = req.getParameter("videoId");
		
		if(videoId == null) {
			req.getRequestDispatcher("/Homepage").forward(req, resp);
			return;
		}
		try {
			FavoriteDAO dao = new FavoriteDAO(Favorite.class);
			Favorite favorite = new Favorite();

			Video video = new VideoDAO(Video.class).findById(videoId);
			favorite.setVideo(video);
			

			User user = new UserDAO(User.class).findById(SessionUtils.getLoginedUsername(req));
			favorite.setUser(user);
			
			favorite.setLikedDate(new Date());
			dao.insert(favorite);
			
			req.setAttribute("message", "Video is added to Favorite");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		
		if(page == null) {
			page = "/Homepage";
		}
		req.getRequestDispatcher(page).forward(req, resp);
		
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
