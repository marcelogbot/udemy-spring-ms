package com.cursoudemy.hrpayroll.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cursoudemy.hrpayroll.model.Worker;

@Component
@FeignClient(name = "hr-worker", path = "worker")
public interface WorkerFeingClient {

    @GetMapping("/{workerId}")
    ResponseEntity<Worker> findById(@PathVariable Long workerId);
    
}
