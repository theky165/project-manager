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

import java.sql.Date;
import java.time.LocalDate;
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
        return findPaginated(1, "", model);
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

    @RequestMapping("/add")
    public String addProject(ModelMap model) {
        List<Employee> employeeList = employeeService.listAll();
        model.addAttribute("employeeList", employeeList);
        List<Language> languageList = languageService.listAll();
        model.addAttribute("languageList", languageList);
        return "add-project";
    }

    @RequestMapping("/save")
    public String saveProject(ModelMap model, Project project) {
//        project.setStart_date(LocalDate.now());
        projectService.saveOrUpdateProject(project);
        List<Project> projectList = projectService.listAll();
        model.addAttribute("projectList", projectList);
        return "redirect:/project/all";
    }

    @RequestMapping("/update/{id}")
    public String updateProject(ModelMap model, @PathVariable(name = "id") Integer id) {
        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        List<Employee> employeeList = employeeService.findAllEmployeeAvailable(id);
        model.addAttribute("employeeList", employeeList);
        List<Language> languageList = languageService.listAll();
        model.addAttribute("languageList", languageList);
        return "update-project";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProject(ModelMap model, @PathVariable(name = "id") Integer id) {
        projectService.deleteProject(id);
        List<Project> projectList = projectService.listAll();
        model.addAttribute("projectList", projectList);
        return "redirect:/project/all";
    }
}
