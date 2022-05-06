package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Status;

import java.util.List;

public interface StatusService {
    List<Status> listAll();

    void saveOrUpdateStatus(Status status);

    void deleteStatus(Integer id);

    Status findById(Integer id);
}
