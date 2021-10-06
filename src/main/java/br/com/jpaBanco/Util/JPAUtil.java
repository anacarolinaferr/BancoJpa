package br.com.jpaBanco.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil{

    private static EntityManager em;

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaAula");
        em = factory.createEntityManager();
        return em;
    }
}