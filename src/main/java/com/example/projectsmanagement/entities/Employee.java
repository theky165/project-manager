package com.example.projectsmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

//POJO
@Entity(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Role role;

    private Boolean status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_start_work;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employees_languages",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects = new LinkedHashSet<>();

    public Employee() {
    }

    public Employee(Integer id, String name, Role role, Boolean status, LocalDate date_start_work, Set<Language> languages, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.status = status;
        this.date_start_work = date_start_work;
        this.languages = languages;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getDate_start_work() {
        return date_start_work;
    }

    public void setDate_start_work(LocalDate date_start_work) {
        this.date_start_work = date_start_work;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
