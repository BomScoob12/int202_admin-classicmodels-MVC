package com.int202.int202_classicmodels_webapp_javaservlet.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table(name = "offices")

@NamedQueries({
        @NamedQuery(name = "OFFICE.FIND_ALL", query = "SELECT o from Office o")
})
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employeeList;
}
