package com.int202.int202_classicmodels_webapp_javaservlet.repositories;

import com.int202.int202_classicmodels_webapp_javaservlet.entities.Employee;
import com.int202.int202_classicmodels_webapp_javaservlet.repositories.utils.EntityManagerBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class EmployeeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager(){
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

    public Employee findByEmail(String user_email){
        Query query = getEntityManager().createNamedQuery("EMP.FIND_BY_EMAIL");
        query.setParameter("emp_email", user_email);
        return (Employee) query.getSingleResult();
    }
}
