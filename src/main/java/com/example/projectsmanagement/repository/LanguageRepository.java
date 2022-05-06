package com.example.projectsmanagement.repository;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
