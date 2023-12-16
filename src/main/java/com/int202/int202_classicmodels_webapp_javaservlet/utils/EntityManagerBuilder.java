package com.int202.int202_classicmodels_webapp_javaservlet.utils;

import com.int202.int202_classicmodels_webapp_javaservlet.entities.Environment;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);

}

