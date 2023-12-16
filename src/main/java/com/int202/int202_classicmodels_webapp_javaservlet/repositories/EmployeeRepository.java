package com.int202.int202_classicmodels_webapp_javaservlet.repositories;

import com.int202.int202_classicmodels_webapp_javaservlet.entities.Employee;
import com.int202.int202_classicmodels_webapp_javaservlet.repositories.utils.EntityManagerBuilder;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager(){
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public List<Employee> findAll() {
        return getEntityManager().createNamedQuery("EMP.FIND_ALL").getResultList();
    }
}
