package com.example.projectsmanagement.repository;

import com.example.projectsmanagement.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Custom query
    @Query(value = "select e from employee e where e.name like %:keyword%")
    Page<Employee> findAllByName(@Param("keyword") String keyword, Pageable pageable);
}
