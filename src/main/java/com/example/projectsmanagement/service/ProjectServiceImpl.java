package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Project;
import com.example.projectsmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> listAll() {
        return projectRepository.findAll();
    }

    @Override
    public void saveOrUpdateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.deleteById(project.getId());
    }

    @Override
    public Project findById(Integer id) {
            Optional<Project> projectOptional = projectRepository.findById(id);
            if (!projectOptional.isPresent()) {
                return new Project();
            }
            return projectOptional.get();
    }
}
