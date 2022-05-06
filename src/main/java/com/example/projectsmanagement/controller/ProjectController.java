package com.example.projectsmanagement.controller;

import com.example.projectsmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/all")
    public String listProject(ModelMap model) {
//        List<Project> projectList = projectService.listAll();
//        model.addAttribute("projectList", projectList);
        return "tables";
    }
}
