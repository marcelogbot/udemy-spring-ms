package com.cursoudemy.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursoudemy.hrpayroll.model.Payment;
import com.cursoudemy.hrpayroll.model.Worker;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("workerId",workerId.toString());
        Worker worker = restTemplate.getForObject(workerHost+"/worker/{workerId}",Worker.class, uriVariables);
        

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
    
}
