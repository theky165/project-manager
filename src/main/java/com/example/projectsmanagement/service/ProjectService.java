package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> listAll();

    void saveOrUpdateProject(Project project);

    void deleteProject(Project project);

    Project findById(Integer id);
}
