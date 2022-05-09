package com.example.projectsmanagement.controller;

import com.example.projectsmanagement.entities.*;
import com.example.projectsmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("all")
    public String listEmployee(ModelMap model) {
        String keyword = "";
        return findPaginated(1,"", model);
    }

    @RequestMapping("page/{pageNo}")
    public String findPaginated(@PathVariable(name = "pageNo") int pageNo, String keyword, ModelMap model) {
        int pageSize = 5;
        Page<Employee> employeeList = employeeService.searchWithPaginated(pageNo, pageSize, keyword);
        List<Role> roleList = roleService.listAll();
        List<Language> languageList = languageService.listAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("languageList", languageList);
        model.addAttribute("keyword", keyword);
        return "employee";
    }

    @RequestMapping("/layout")
    public String testEmployee() {
        return "index";
    }

    @RequestMapping("/add")
    public String addEmployee(ModelMap model) {
        List<Role> roleList = roleService.listAll();
        model.addAttribute("roleList", roleList);
        List<Language> languageList = languageService.listAll();
        model.addAttribute("languageList", languageList);
        return "add-employee";
    }

    @RequestMapping("/save")
    public String saveEmployee(ModelMap model, Employee employee) {
        employee.setUpdate_at(LocalDate.now());
        employeeService.saveOrUpdateEmployee(employee);
        List<Employee> employeeList = employeeService.listAll();
        model.addAttribute("employeeList", employeeList);
        return "redirect:/employee/all";
    }

    @RequestMapping("/update/{id}")
    public String updateEmployee(ModelMap model, @PathVariable(name = "id") Integer id) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        List<Role> roleList = roleService.listAll();
        model.addAttribute("roleList", roleList);
        List<Language> languageList = languageService.listAll();
        model.addAttribute("languageList", languageList);
        List<Project> projectListByEmployeeId = projectService.findAllProjectByEmployeeId(id);
        model.addAttribute("projectListByEmployeeId", projectListByEmployeeId);
        return "update-employee";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(ModelMap model, @PathVariable(name = "id") Integer id) {
        employeeService.deleteEmployee(id);
        List<Employee> employeeList = employeeService.listAll();
        model.addAttribute("employeeList", employeeList);
        return "redirect:/employee/all";
    }
}
