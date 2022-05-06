package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Status;
import com.example.projectsmanagement.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> listAll() {
        return statusRepository.findAll();
    }

    @Override
    public void saveOrUpdateStatus(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void deleteStatus(Integer id) {
        statusRepository.deleteById(id);
    }

    @Override
    public Status findById(Integer id) {
        Optional<Status> projectOptional = statusRepository.findById(id);
        if (!projectOptional.isPresent()) {
            return new Status();
        }
        return projectOptional.get();
    }
}
