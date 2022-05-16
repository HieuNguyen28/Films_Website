package com.fpoly.Servlet.Services;


import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.VideoDAO;

public class VideoService {
	VideoDAO videoDao = new VideoDAO(Video.class);
	
	public Video findOneById(String videoId) {
		return videoDao.findOneById(videoId);
	}
}
