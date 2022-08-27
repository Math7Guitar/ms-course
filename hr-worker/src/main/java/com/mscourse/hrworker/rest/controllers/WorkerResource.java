package com.mscourse.hrworker.rest.controllers;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.mscourse.hrworker.config.GreetingConfig;
import com.mscourse.hrworker.model.classes.Greeting;
import com.mscourse.hrworker.model.entities.Worker;
import com.mscourse.hrworker.rest.exceptions.Worker.DeleteWorkerException;
import com.mscourse.hrworker.rest.exceptions.Worker.SaveWorkerException;
import com.mscourse.hrworker.rest.exceptions.Worker.UpdateWorkerException;
import com.mscourse.hrworker.rest.exceptions.Worker.WorkerListException;
import com.mscourse.hrworker.rest.services.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/hr-worker")
@RefreshScope
@Tag(name = "Workers Resource API REST")
public class WorkerResource {

    @Autowired
    private WorkerService service;
    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private GreetingConfig config;


    @GetMapping("/info")
    public Greeting info(@RequestParam(value="name", defaultValue = "World!") String name) {
        if(name.isEmpty()) {
            name = config.getDefaultValue();
        }
        return new Greeting(1, String.format(template, config.getGreeting(), name));
    }

    
    //CRUD
    @PostMapping @ResponseStatus(HttpStatus.CREATED) @Operation(summary="Save a worker on db")
    public ResponseEntity<Worker> saveWorker(@RequestBody @Valid Worker worker) {
        try {
            service.saveWorker(worker);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(worker.getId()).toUri();
            return ResponseEntity.created(uri).body(worker);
        } catch (SaveWorkerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping @ResponseStatus(HttpStatus.FOUND) @Operation(summary="Bring a worker list from db")
    public ResponseEntity<List<Worker>> workerList() {
        try {
            List<Worker> workerList = service.workerList();
            return ResponseEntity.ok().body(workerList);
        } catch (WorkerListException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}") @ResponseStatus(HttpStatus.FOUND) @Operation(summary="Consult a worker on db")
    public ResponseEntity<Worker> consultWorker(@PathVariable Long id) {
        try {
            Worker worker = service.findWorkerById(id);
            return ResponseEntity.ok().body(worker);
        } catch (WorkerListException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}") @Operation(summary="Update a worker on db")
    public ResponseEntity<Worker> updateWorker(Long id, Worker update) {
        try {
            Worker updated = new Worker();
            service.updateWorker(id, update);
            return ResponseEntity.ok().body(updated);
        } catch (UpdateWorkerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}") @Operation(summary="Delete a worker on db")
    public ResponseEntity<Void> deleteMeet(@PathVariable Long id) {
        try {
            service.deleteWorker(id);
            return ResponseEntity.ok().build();
        } catch( DeleteWorkerException e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
