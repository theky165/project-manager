package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> listAll();

    void saveOrUpdateRole(Role role);

    void deleteRole(Role role);

    Role findById(Integer id);
}
