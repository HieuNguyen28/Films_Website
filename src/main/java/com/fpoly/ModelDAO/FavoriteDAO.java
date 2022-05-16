package com.fpoly.ModelDAO;

import com.fpoly.Items.FavoriteReport;
import com.fpoly.Items.FavoriteUserReport;
import com.fpoly.Model.Favorite;
import com.fpoly.Model.Video;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavoriteDAO extends HandleEntityDAO<Favorite>{

    public FavoriteDAO(Class<Favorite> entityClass) {
        super(entityClass);
    }

    public List<FavoriteUserReport> reportFavoriteUsersByVideo(String videoId){
        String jpql = "select new com.fpoly.Items.FavoriteUserReport(f.user.userName, f.user.fullName, "
                + "f.user.email, f.likedDate) from Favorite f where f.video.videoId = :videoId";

        EntityManager em = JpaUtils.getEntityManager();

        List<FavoriteUserReport> list = null;

        try {
            TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);

            query.setParameter("videoId", videoId);

            list = query.getResultList();
        } finally {
            em.close();
        }

        return list;

    }

    public List<FavoriteReport> reportFavoritesByVideos(){
        String jpql = "select new com.fpoly.Items.FavoriteReport(f.video.title, count(f), min(f.likedDate), max(f.likedDate)) "
                + " from Favorite f group by f.video.title ";

        EntityManager em = JpaUtils.getEntityManager();

        List<FavoriteReport> list = null;

        try {
            TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);

            list = query.getResultList();
        } finally {
            em.close();
        }

        return list;
    }
    public List<Video> findAllByUsername(String videoId) {
        EntityManager em= JpaUtils.getEntityManager();
        em.clear();
        List<Video> list = null;
        try {
            String sql = "SELECT v.video FROM Favorite v WHERE v.user.userName = :videoId";
            TypedQuery<Video> query = em.createQuery(sql, Video.class);
            query.setParameter("videoId", videoId);
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}