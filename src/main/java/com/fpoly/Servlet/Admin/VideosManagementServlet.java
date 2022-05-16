package com.fpoly.Servlet.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Model.Favorite;
import com.fpoly.Model.Share;
import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.FavoriteDAO;
import com.fpoly.ModelDAO.ShareDAO;
import com.fpoly.ModelDAO.VideoDAO;
import com.fpoly.Utils.SessionUtils;
import com.fpoly.Utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class VideosManagementServlet
 */
@WebServlet({"/Admin/VideosManagement", "/Admin/VideosManagement/create",
	"/Admin/VideosManagement/update", "/Admin/VideosManagement/delete", 
	"/Admin/VideosManagement/reset", "/Admin/VideosManagement/edit", })
@MultipartConfig
public class VideosManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		Video video = new Video();
		video.setPoster("Back_ground_index.png");
		
		List<Video> list = new VideoDAO(Video.class).findAll();
		Long countVideo = new VideoDAO(Video.class).count();
		Long countLike = new FavoriteDAO(Favorite.class).count();
		Long countShare = new ShareDAO(Share.class).count();
		req.setAttribute("totalVideos",countVideo);
		req.setAttribute("ratingLikes", countLike);
		req.setAttribute("totalShared", countShare);

		req.setAttribute("videos", list);
		req.setAttribute("video", video);

		req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(req);
		System.out.println("def");
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
		}else{
			doGet(req,resp);
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        String id = req.getParameter("videoId");
		
		if (id == null) {
			req.setAttribute("error", "Video id is required!");
			req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
			return;
		}
		try {
			
			VideoDAO dao = new VideoDAO(Video.class);
			Video video = dao.findById(id);
			
			if (video == null) {
				req.setAttribute("error", "Video id not found!");
				req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
				return;
			}
			
			dao.delete(id);
			req.setAttribute("message", "video is deleted!");
			
			req.setAttribute("video", new Video());
			findAll(req, resp);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		
        try {
			BeanUtils.populate(video, req.getParameterMap());
        	
			VideoDAO dao = new VideoDAO(Video.class);
			Video oldVideo = dao.findById(video.getVideoId());
			
			if (req.getPart("poster").getSize()==0) {
				video.setPoster(oldVideo.getPoster());
			}else {
				video.setPoster("" + UploadUtils.processUploadField("poster", req,
						"/views/Picture", video.getPoster()));
			}
			
			dao.update(video);
			
			req.setAttribute("video", video);
			req.setAttribute("message", "Video is update!");
			
			findAll(req, resp);
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
	}
	
	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		
        try {
        	
			VideoDAO dao = new VideoDAO(Video.class);
			
			List<Video> list = dao.findAll();
			
			req.setAttribute("videos", list);
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoId");
		
		if (id == null) {
			req.setAttribute("error", "Video id is required!");
			req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
			return;
		}
		try {
			
			VideoDAO dao = new VideoDAO(Video.class);
			Video video = dao.findById(id);
			
			req.setAttribute("video", video);
			List<Video> list = new VideoDAO(Video.class).findAll();
			req.setAttribute("videos", list);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			req.setAttribute("error", "Error: "+ e.getMessage());
		}
		req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
		
	}
    
	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		video.setPoster("image/12.jpg");
		
		req.setAttribute("video", video);
		findAll(req, resp);
		req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
		
	}

	
	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			
			video.setPoster("" + UploadUtils.processUploadField("poster", req, "/views/Picture", video.getVideoId()));
			
			VideoDAO dao = new VideoDAO(Video.class);
			dao.insert(video);
			
			req.setAttribute("video", video);
			req.setAttribute("message", "Video is inserted! " );
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/Admin_Edit_Video.jsp").forward(req,resp);
	}

}
