package com.cursoudemy.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.hrworker.model.Worker;
import com.cursoudemy.hrworker.repositories.WorkerRepository;

@Service
public class WorkerServices {
    
    @Autowired
    private WorkerRepository workerR;

    public List<Worker> findAll() {
        
        return workerR.findAll();
    }

    public Worker findById(Long workerId) {
        return workerR.findById(workerId).get();
    }
}
