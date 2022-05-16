package com.fpoly.Servlet.Admin;

import com.fpoly.Items.FavoriteReport;
import com.fpoly.Items.FavoriteUserReport;
import com.fpoly.Model.Favorite;
import com.fpoly.Model.Share;
import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.FavoriteDAO;
import com.fpoly.ModelDAO.ShareDAO;
import com.fpoly.ModelDAO.VideoDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ReportManagementServlet
 */
@WebServlet("/ReportManagementServlet")
public class ReportManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		reportFavoritesByVideos(req, resp);
		reportFavoriteUsersByVideo(req, resp);
		reportShareFriendsByUser(req,resp);
		req.getRequestDispatcher("/views/Admin_Report.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	protected void reportShareFriendsByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			String videoUserId = req.getParameter("videoUserId");
			ShareDAO shareDAO = new ShareDAO(Share.class);
			List<Share> shareList = shareDAO.getShareList(videoUserId);
			req.setAttribute("shareList", shareList);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	protected void reportFavoriteUsersByVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String videoUserId = req.getParameter("videoUserId");
			
			VideoDAO vdao = new VideoDAO(Video.class);
			List<Video> vList = vdao.findAll();
			
			if(videoUserId == null && vList.size()>0) {
				videoUserId = vList.get(0).getVideoId();
			}
			
			FavoriteDAO dao = new FavoriteDAO(Favorite.class);
			
			List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideo(videoUserId);
			
			req.setAttribute("videoUserId", videoUserId);
			req.setAttribute("vidList", vList);
			req.setAttribute("favUsers", list);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
    protected void reportFavoritesByVideos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FavoriteDAO dao = new FavoriteDAO(Favorite.class);
			List<FavoriteReport> list = dao.reportFavoritesByVideos();
			
			req.setAttribute("favList", list);
		} catch (Exception e) {
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
