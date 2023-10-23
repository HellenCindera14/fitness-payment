package com.example.fitnespayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fitnespayment.kafka.PaymentProducer;
import com.example.fitnespayment.model.PaymentRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentProducer paymentProducer;

    @PostMapping("/process")
     public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        paymentProducer.sendPaymentRequest(paymentRequest);
        return ResponseEntity.ok("PROCESSING");
    }

    
}
