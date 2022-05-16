package com.fpoly.Servlet;

import com.fpoly.Model.Video;
import com.fpoly.Servlet.Services.FavoriteService;
import com.fpoly.Utils.SessionUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			FavoriteService fvs = new FavoriteService();
		
			if(!SessionUtils.isLogin(req)) {
				req.getRequestDispatcher("/LoginServlet").forward(req, resp);
				return;
			}
			else {
				try {
					String username = SessionUtils.getLoginedUsername(req);
					List<Video> list = fvs.findAllByUserId(username);
					req.setAttribute("listFavoriteVideo", list);
					req.getRequestDispatcher("/views/User_MyFavorites.jsp").forward(req, resp);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
