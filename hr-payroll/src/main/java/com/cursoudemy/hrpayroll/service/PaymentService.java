package com.cursoudemy.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.hrpayroll.feignClients.WorkerFeingClient;
import com.cursoudemy.hrpayroll.model.Payment;
import com.cursoudemy.hrpayroll.model.Worker;

import lombok.extern.slf4j.Slf4j;

@Service 
@Slf4j
public class PaymentService {

    @Autowired
    private WorkerFeingClient workerFeingClient;

    public Payment getPayment(Long workerId, int days) {

        Worker worker = workerFeingClient.findById(workerId).getBody();
        log.info("Worker: {}",worker);
        
        if(worker != null) {
            return new Payment(worker.getName(), worker.getDailyIncome(), days);
        } else {
            log.info("Worker nao encontrado.");
            return null;
        }
        
    }
    
}
