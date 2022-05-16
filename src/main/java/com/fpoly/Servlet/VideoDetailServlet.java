package com.fpoly.Servlet;

import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.VideoDAO;
import com.fpoly.Servlet.Services.VideoService;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class VideodetailServlet
 */
@WebServlet("/VideoDetailServlet")
public class VideoDetailServlet extends HttpServlet {
      
	VideoService vds = new VideoService();
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> list = new VideoDAO(Video.class).loadVideosSuggestions(req.getParameter("videoId"));
		Video video = vds.findOneById(req.getParameter("videoId"));
		
		req.setAttribute("video", video);
		req.setAttribute("videos", list);
//		PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_VIDEO_DETAIL_PAGE);
		req.getRequestDispatcher("/views/Watch_Video.jsp").forward(req, resp);

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
