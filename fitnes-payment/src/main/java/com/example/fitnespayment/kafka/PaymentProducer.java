package com.example.fitnespayment.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.fitnespayment.model.PaymentRequest;
import com.example.fitnespayment.kafka.PaymentProducer;
import org.springframework.kafka.core.KafkaTemplate;



@Component
public class PaymentProducer {

    @Autowired
    private KafkaTemplate<String, PaymentRequest> kafkaTemplate;

     @Value("${kafka.topic.payment}")
    private String paymentTopic;

    public void sendPaymentRequest(PaymentRequest paymentRequest) {
        kafkaTemplate.send(paymentTopic, paymentRequest);
    }
    
}
