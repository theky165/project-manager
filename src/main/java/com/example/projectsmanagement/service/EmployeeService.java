package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();

    List<Employee> findAllBySameLanguageWithProject(Integer id);
    List<Employee> findAllEmployeeByLanguage(Integer id);

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee findById(Integer id);

    Page<Employee> findPaginated(int pageNo, int pageSize);

    Page<Employee> searchWithPaginated(int pageNo, int pageSize, String keyword);
}
