package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Project;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    List<Project> listAll();

    void saveOrUpdateProject(Project project);

    void deleteProject(Integer id);

    Project findById(Integer id);
    Page<Project> findPaginated(int pageNo, int pageSize);

    Page<Project> searchWithPaginated(int pageNo, int pageSize, String keyword);
}
