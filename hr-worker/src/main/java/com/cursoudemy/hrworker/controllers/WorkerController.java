package com.cursoudemy.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.hrworker.model.Worker;
import com.cursoudemy.hrworker.services.WorkerServices;

import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping(path = "worker")
public class WorkerController {

    @Autowired
    private Environment env;
    
    @Autowired
    private WorkerServices workerS;

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> findAll() {
        
        return ResponseEntity.ok(workerS.findAll());
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> findById(@PathVariable Long workerId) {

        log.info("PORT = {}",env.getProperty("local.server.port"));
        return ResponseEntity.ok(workerS.findById(workerId));
    }
}
