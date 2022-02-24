package com.mscourse.hrworker.rest.services;

import java.util.List;
import java.util.Optional;

import com.mscourse.hrworker.model.entities.Worker;
import com.mscourse.hrworker.model.repositories.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WorkerService {
    
    private final WorkerRepository repository;

    @Autowired
    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }

    //CRUD
    public Worker saveWorker(Worker worker) {
        return repository.save(worker);
    }

    public List<Worker> workerList() {
        return repository.findAll();
    }

    public Optional<Worker> findWorkerById(Long id) {
        return repository.findById(id);
    }

    public Worker updateWorker(Long id, Worker update) {
        return repository.findById(id).map( worker -> {
            update.setId(worker.getId());
            return repository.save(update);
     }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_MODIFIED));
    }

    public void deleteWorker(Long id) {
        repository.findById(id).map( worker -> {
            repository.delete(worker);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
    
}
