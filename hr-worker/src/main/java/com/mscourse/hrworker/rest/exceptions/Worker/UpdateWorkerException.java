package com.mscourse.hrworker.rest.exceptions.Worker;

public class UpdateWorkerException extends RuntimeException {

    public UpdateWorkerException(String id) {
        super("Failed to update worker with id: " + id);
    }
}
