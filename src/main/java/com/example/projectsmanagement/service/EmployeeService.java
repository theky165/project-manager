package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();

    List<Employee> findAllEmployeeByProjectLanguage(Integer project_id);
    List<Employee> findAllEmployeeLessThan3Projects();
    List<Employee> findAllEmployeeAvailable(Integer project_id);

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee findById(Integer id);

    Page<Employee> findPaginated(int pageNo, int pageSize);

    Page<Employee> searchWithPaginated(int pageNo, int pageSize, String keyword);
}
