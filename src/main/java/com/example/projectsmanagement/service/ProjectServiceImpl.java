package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Project;
import com.example.projectsmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Project> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return projectRepository.findAll(pageable);
    }

    @Override
    public Page<Project> searchWithPaginated(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        if (keyword != null) {
            return projectRepository.findAllByName(keyword, pageable);
        }
        return projectRepository.findAll(pageable);
    }
}
