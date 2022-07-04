package com.mscourse.hrpayroll.rest.services;

import com.mscourse.hrpayroll.model.classes.Worker;
import com.mscourse.hrpayroll.model.entities.Payment;
import com.mscourse.hrpayroll.model.interfaces.WorkerFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient wfc;

    public Payment getPayment(long workerid, int days) {
        Worker worker = wfc.consultWorker(workerid).getBody();
        return new Payment(worker.getName(),worker.getDailyIncome(), days);
    }
    
}
