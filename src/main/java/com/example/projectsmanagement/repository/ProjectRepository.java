package com.example.projectsmanagement.repository;

import com.example.projectsmanagement.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "select p from project p where p.name like %:keyword%")
    Page<Project> findAllByName(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "SELECT p.* from project p inner join projects_employees pe\n" +
            "on p.id = pe.project_id inner join employee e\n" +
            "on pe.employee_id = e.id\n" +
            "where e.id = :id", nativeQuery = true)
    List<Project> findAllProjectByEmployeeId(@Param("id") Integer id);
}
