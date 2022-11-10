package com.cursoudemy.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.hrworker.model.Worker;
import com.cursoudemy.hrworker.services.WorkerServices;

@RestController
@RequestMapping(path = "worker")
public class WorkerController {
    
    @Autowired
    private WorkerServices workerS;

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> findAll() {
        
        return ResponseEntity.ok(workerS.findAll());
    }
}
