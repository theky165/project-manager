package com.example.projectsmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//POJO
@Entity(name = "projects_employees")
public class ProjectsEmployees implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Project project;
    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Employee employee;

    public ProjectsEmployees() {
    }

    public ProjectsEmployees(Project project, Employee employee) {
        this.project = project;
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
