package com.fpoly.Servlet;

import com.fpoly.Items.Email;
import com.fpoly.Model.Share;
import com.fpoly.Model.User;
import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.ShareDAO;
import com.fpoly.Utils.EmailUtils;
import com.fpoly.Utils.SessionUtils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/ShareVideo")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String videoId = req.getParameter("videoId");
		
		if(!SessionUtils.isLogin(req)) {
			resp.sendRedirect("/LoginServlet");
			return;
		}
		if(videoId == null) {
			resp.sendRedirect("/Homepage");
			return;
		}
		
		req.setAttribute("videoId", videoId);
		req.getRequestDispatcher("/views/User_ShareVideo.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String emailAddress = req.getParameter("email");
			String videoId = req.getParameter("videoId");
			
			
			
			if (videoId == null) {
				req.setAttribute("error", "VideoId is null!");
			}else {
				Email email = new Email();
				email.setFrom("socola2067@gmail.com");
				email.setFromPassword("mbcyrwhfbwwztwps");
				email.setTo(emailAddress);
				email.setSubbjet("Share Favorite Video");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear Ms/Mr. <br>");
				sb.append("The video is more interesting and I want to share with you <br> ");
				sb.append("Please click the link ").append(String.format("<a href='http://localhost:8080/PS15722_NguyenChiHieu_ASM_war_exploded/VideoDetailServlet?videoId="+ videoId+
						" '>View Video</a> <br> "));
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				ShareDAO dao = new ShareDAO(Share.class);
				Share share = new Share();
				share.setEmails(emailAddress);
				share.setSharedDate(new Date());
				
				String username = SessionUtils.getLoginedUsername(req);
				User user = new User();
				user.setUserName(username);
				
				share.setUser(user);
				Video video  = new Video();
				video.setVideoId(videoId);
				share.setVideo(video);
				
				dao.insert(share);
				req.setAttribute("message", "Video link has been sent");		
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/User_ShareVideo.jsp").forward(req, resp);
	}

}
