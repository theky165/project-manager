package com.example.projectsmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//POJO
@Entity(name = "projects_languages")
public class ProjectsLanguages implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Project project;
    @Id
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Language language;

    public ProjectsLanguages() {
    }

    public ProjectsLanguages(Project project, Language language) {
        this.project = project;
        this.language = language;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
