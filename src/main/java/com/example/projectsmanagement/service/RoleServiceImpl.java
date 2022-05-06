package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Role;
import com.example.projectsmanagement.repository.RoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRespository roleRespository;

    @Override
    public List<Role> listAll() {
        return roleRespository.findAll();
    }

    @Override
    public void saveOrUpdateRole(Role role) {
        roleRespository.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleRespository.deleteById(role.getId());
    }

    @Override
    public Role findById(Integer id) {
        Optional<Role> projectOptional = roleRespository.findById(id);
        if (!projectOptional.isPresent()) {
            return new Role();
        }
        return projectOptional.get();
    }
}
