package com.mscourse.hrpayroll.model.interfaces;

import com.mscourse.hrpayroll.model.classes.Worker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker")
public interface WorkerFeignClient {
    
    @GetMapping("/{id}")
    ResponseEntity<Worker> consultWorker(@PathVariable Long id);
}