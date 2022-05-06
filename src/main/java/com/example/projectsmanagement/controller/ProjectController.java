package com.example.projectsmanagement.controller;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Language;
import com.example.projectsmanagement.entities.Project;
import com.example.projectsmanagement.entities.Role;
import com.example.projectsmanagement.service.EmployeeService;
import com.example.projectsmanagement.service.LanguageService;
import com.example.projectsmanagement.service.ProjectService;
import com.example.projectsmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private LanguageService languageService;

    @RequestMapping("all")
    public String listProject(ModelMap model) {
        String keyword = "";
        return findPaginated(1,"", model);
    }

    @RequestMapping("page/{pageNo}")
    public String findPaginated(@PathVariable(name = "pageNo") int pageNo, String keyword, ModelMap model) {
        int pageSize = 5;
        Page<Project> projectList = projectService.searchWithPaginated(pageNo, pageSize, keyword);
        List<Role> roleList = roleService.listAll();
        List<Language> languageList = languageService.listAll();
        model.addAttribute("projectList", projectList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("languageList", languageList);
        model.addAttribute("keyword", keyword);
        return "project";
    }
}
