package com.cursoudemy.hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.hrpayroll.model.Payment;
import com.cursoudemy.hrpayroll.service.PaymentService;

@RestController
@RequestMapping(path = "payment")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentS;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {

        Payment payment = paymentS.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

}
