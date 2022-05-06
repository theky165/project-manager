package com.example.projectsmanagement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

//POJO
@Entity(name = "language")
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "languages")
    private Set<Employee> employees = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "languages")
    private Set<Project> projects = new LinkedHashSet<>();

    public Language() {
    }

    public Language(Integer id, String name, Set<Employee> employees, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.projects = projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
