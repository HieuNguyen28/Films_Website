package com.fpoly.ModelDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("Java4_Group1").createEntityManager();
    }
}
