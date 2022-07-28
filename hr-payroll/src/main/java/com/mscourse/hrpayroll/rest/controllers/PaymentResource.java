package com.mscourse.hrpayroll.rest.controllers;

import com.mscourse.hrpayroll.model.entities.Payment;
import com.mscourse.hrpayroll.rest.services.PaymentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/hr-payroll")
@Tag(name = "Payroll Resource API REST")
@RefreshScope
public class PaymentResource {
    
    private PaymentService service;
    private Logger logger = LoggerFactory.getLogger(PaymentResource.class);

    @Autowired
    public PaymentResource(PaymentService service) {
        this.service = service;
    }

    @GetMapping(value="/{id}/{days}") @Operation(summary = "Return a specific payment")
    @Retry(name = "getPayment", fallbackMethod = "getPaymentFallback")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days) {
        logger.info("Payment Request Received!");
        Payment payment = service.getPayment(id, days);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<Payment> getPaymentFallback(Exception ex, Long id, Integer days) {
        Payment payment = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok().body(payment);
    }
}
