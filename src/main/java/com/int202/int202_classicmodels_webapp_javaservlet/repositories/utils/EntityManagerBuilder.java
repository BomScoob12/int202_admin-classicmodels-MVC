package com.int202.int202_classicmodels_webapp_javaservlet.repositories.utils;

import com.int202.int202_classicmodels_webapp_javaservlet.entities.utils.Environment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
    public static EntityManager getEntityManager(){ return entityManagerFactory.createEntityManager();}
}

