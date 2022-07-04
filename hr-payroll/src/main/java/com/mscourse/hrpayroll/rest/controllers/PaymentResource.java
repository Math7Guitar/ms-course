package com.mscourse.hrpayroll.rest.controllers;

import com.mscourse.hrpayroll.model.entities.Payment;
import com.mscourse.hrpayroll.rest.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/payments")
public class PaymentResource {
    
    private PaymentService service;

    @Autowired
    public PaymentResource(PaymentService service) {
        this.service = service;
    }

    //@HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value="/{id}/{days}") @ApiOperation(value = "Return a specific payment")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days) {
        Payment payment = service.getPayment(id, days);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long id, Integer days) {
        Payment payment = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok().body(payment);
    }
}
