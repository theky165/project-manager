package com.example.projectsmanagement.repository;

import com.example.projectsmanagement.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "select p from project p where p.name like %:keyword%")
    Page<Project> findAllByName(@Param("keyword") String keyword, Pageable pageable);
}
