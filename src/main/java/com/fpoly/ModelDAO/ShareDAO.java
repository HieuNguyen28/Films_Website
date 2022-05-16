package com.fpoly.ModelDAO;

import com.fpoly.Model.Share;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class ShareDAO extends HandleEntityDAO<Share> {

    public ShareDAO(Class<Share> entityClass) {
        super(entityClass);
    }

    public List<Share> getShareList(String videoId) {
        EntityManager em = JpaUtils.getEntityManager();
        em.clear();

        final String jpql ="SELECT o FROM Share o WHERE o.video.videoId = ?1 ";

        TypedQuery<Share> query = em.createQuery(jpql, Share.class);
        query.setParameter(1, videoId);
        return query.getResultList();
    }
}
