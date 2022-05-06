package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();

    void saveOrUpdateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee findById(Integer id);

//    List<Employee> searchByKeyword(String keyword);

    Page<Employee> findPaginated(int pageNo, int pageSize);

    Page<Employee> searchWithPaginated(int pageNo, int pageSize, String keyword);
}
