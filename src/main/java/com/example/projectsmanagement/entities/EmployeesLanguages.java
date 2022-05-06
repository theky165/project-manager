package com.example.projectsmanagement.entities;

import javax.persistence.*;
import java.io.Serializable;

//POJO
public class EmployeesLanguages implements Serializable {
    @ManyToOne
    @MapsId("Id")
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @MapsId("Id")
    @Column(name = "language_id")
    private Language language;

    public EmployeesLanguages() {
    }

    public EmployeesLanguages(Employee employee, Language language) {
        this.employee = employee;
        this.language = language;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
