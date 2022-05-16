package com.fpoly.ModelDAO;

import com.fpoly.Model.Video;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VideoDAO extends HandleEntityDAO<Video> {

    public VideoDAO(Class<Video> entityClass) {
        super(entityClass);
    }

    public Video findOneById(String videoId) {
        EntityManager em = JpaUtils.getEntityManager();
        em.clear();
        try {
            Video video = em.find(Video.class, videoId);
            return video;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Video> loadVideosSuggestions(String videoId) {
        EntityManager em = JpaUtils.getEntityManager();
        em.clear();

        final String jpql ="SELECT o FROM Video o WHERE o.videoId NOT LIKE ?1  ORDER BY NEWID() ";

        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter(1, videoId);
        return query.getResultList();
    }

    public List<Video> loadVideosActive(Boolean status) {
        EntityManager em = JpaUtils.getEntityManager();
        em.clear();

        final String jpql ="SELECT o FROM Video o WHERE o.active = ? 1   ORDER BY NEWID() ";

        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter(1, status);
        return query.getResultList();
    }

}

