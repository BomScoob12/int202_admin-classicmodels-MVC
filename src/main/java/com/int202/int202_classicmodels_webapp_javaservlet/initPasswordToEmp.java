package com.int202.int202_classicmodels_webapp_javaservlet;

import com.int202.int202_classicmodels_webapp_javaservlet.entities.Employee;
import com.int202.int202_classicmodels_webapp_javaservlet.repositories.EmployeeRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class initPasswordToEmp {
    public static void main(String[] args) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d,16, 16);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.getEntityManager().getTransaction().begin();
        char [] password;
        for (Employee e : employeeRepository.findAll()){
            password = e.getId().toString().toCharArray();
            System.out.println(password);
            e.setPassword(argon2.hash(2,16,1,password));
            System.out.println(e.getPassword());
        }
        employeeRepository.getEntityManager().getTransaction().commit();
    }
}
