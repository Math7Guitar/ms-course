package com.mscourse.hrworker.rest.repositories;

import com.mscourse.hrworker.model.entities.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{
    
}
