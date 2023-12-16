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
        @NamedQuery(name = "FIND_ALL", query = "SELECT emp FROM Employee emp")
})
public class Employee {
    @Id
    private int id;
    @Column(name = "lastName")
    private String lastname;
    @Column(name = "firstName")
    private String firstname;
    private String extension;
    private String email;
    private String officeCode;
    private int reportsTo;
    private String jobTitle;
}
