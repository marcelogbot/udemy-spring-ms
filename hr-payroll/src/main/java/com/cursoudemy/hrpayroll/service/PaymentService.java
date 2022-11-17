package com.cursoudemy.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
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

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;
    
    public Payment getPayment(Long workerId, int days) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        Worker worker = circuitBreaker.run(() -> workerFeingClient.findById(workerId).getBody(), throwable -> getPaymentAlternative(workerId,days));
                
        if(worker != null) {
            return new Payment(worker.getName(), worker.getDailyIncome(), days);
        } else {
            log.info("Worker id: {} nao encontrado.", workerId);
            return null;
        }    
    }

    public Worker getPaymentAlternative(Long workerId, int days) {
        // Worker workerTeste = workerFeingClient.findById(workerId).getBody();
        // log.info("WorkerTest: {}",workerTeste);
        Worker worker = new Worker(workerId,"Brann", 1000.0);
        return worker;
    }
    
}
