package com.mscourse.hrworker.rest.exceptions.Worker;

public class WorkerListException extends RuntimeException {

    public WorkerListException() {
        super("Worker List not found!");
    }
}
