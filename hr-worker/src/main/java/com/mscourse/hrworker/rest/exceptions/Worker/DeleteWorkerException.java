package com.mscourse.hrworker.rest.exceptions.Worker;

public class DeleteWorkerException extends RuntimeException {

    public DeleteWorkerException(Long id) {
        super("Failed to delete worker with id: " + id);
    }
}
