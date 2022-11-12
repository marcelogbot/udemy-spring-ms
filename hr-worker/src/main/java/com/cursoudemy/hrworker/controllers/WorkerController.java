package com.cursoudemy.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.hrworker.model.Worker;
import com.cursoudemy.hrworker.services.WorkerServices;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@RestController @Slf4j
@RequestMapping(path = "/worker")
public class WorkerController {
    
    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerServices workerS;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfig() {
        log.info("CONFG: {}",testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> findAll() {
        
        return ResponseEntity.ok(workerS.findAll());
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> findById(@PathVariable Long workerId) {

        // try {
        //     Thread.sleep(3000L);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        return ResponseEntity.ok(workerS.findById(workerId));
    }
}
