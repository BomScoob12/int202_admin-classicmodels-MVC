package com.int202.int202_classicmodels_webapp_javaservlet;

import com.int202.int202_classicmodels_webapp_javaservlet.entities.Employee;
import com.int202.int202_classicmodels_webapp_javaservlet.repositories.EmployeeRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class TestArgon2 {
    public static void main(String[] args) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        String email = "dmurphy@classicmodelcars.com";
        Employee emp = employeeRepository.findByEmail(email);
        System.out.println(emp.getEmail());
        char [] pass1 = "1002".toCharArray();
        char [] pass2 = "1111".toCharArray();
        boolean isValid1 = argon2.verify(emp.getPassword(), pass1);
        boolean isValid2 = argon2.verify(emp.getEmail(), pass2);
        System.out.println(isValid1);
        System.out.println(isValid2);
    }
}
