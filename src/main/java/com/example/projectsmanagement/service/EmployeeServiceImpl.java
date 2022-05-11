package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Project;
import com.example.projectsmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllEmployeeByProjectLanguage(Integer project_id) {
        return employeeRepository.findAllEmployeeByProjectLanguage(project_id);
    }

    @Override
    public List<Employee> findAllEmployeeLessThan3Projects() {
        return employeeRepository.findAllEmployeeLessThan3Projects();
    }


    @Override
    public List<Employee> findAllEmployeeAvailable(Integer id) {
        List<Employee> result = new ArrayList<>();
        for (Employee employeeLanguage : findAllEmployeeByProjectLanguage(id)) {
            for (Employee employeeLessThan : findAllEmployeeLessThan3Projects()) {
                if (employeeLanguage.getId() == employeeLessThan.getId()) {
                    result.add(employeeLanguage);
                }
            }
        }
        return result;
    }

    public List<Employee> findAllSortByUpdateAtDesc() {
        return employeeRepository.findAllSortByUpdateAtDesc();
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> projectOptional = employeeRepository.findById(id);
        if (!projectOptional.isPresent()) {
            return new Employee();
        }
        return projectOptional.get();
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchWithPaginated(int pageNo, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        if (keyword != null) {
            return employeeRepository.findAllByName(keyword, pageable);
        }
        return employeeRepository.findAll(pageable);
    }
}
