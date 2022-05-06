package com.example.projectsmanagement.repository;

import com.example.projectsmanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRespository extends JpaRepository<Role, Integer> {
}
