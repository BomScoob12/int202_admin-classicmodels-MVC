package com.int202.int202_classicmodels_webapp_javaservlet.entities;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "EMP.FIND_ALL", query = "SELECT emp FROM Employee emp"),
        @NamedQuery(name = "EMP.FIND_BY_EMAIL", query = "SELECT emp FROM Employee emp WHERE emp.email = :emp_email")
})
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    private Integer id;
    @Column(name = "lastName")
    private String lastname;
    @Column(name = "firstName")
    private String firstname;
    private String extension;
    private String email;
    private String password;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "officeCode", insertable = false, updatable = false)
    private Office office;
}
