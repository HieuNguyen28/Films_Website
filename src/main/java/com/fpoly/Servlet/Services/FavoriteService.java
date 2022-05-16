package com.fpoly.Servlet.Services;

import java.util.List;


import com.fpoly.Model.Favorite;
import com.fpoly.Model.Video;
import com.fpoly.ModelDAO.FavoriteDAO;


public class FavoriteService {

	FavoriteDAO favoriteDAO = new FavoriteDAO(Favorite.class);
	
	public void like(Favorite favorite) {
		favoriteDAO.insert(favorite);
	}
	
	public void unlike(Favorite favorite) {
		favoriteDAO.delete(favorite);
	}
	
	public List<Video> findAllByUserId(String user){
		return favoriteDAO.findAllByUsername(user);
	}
	
	
}
