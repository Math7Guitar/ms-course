package com.mscourse.hrworker.rest.exceptions.Worker;

public class SaveWorkerException extends RuntimeException {

    public SaveWorkerException(Long id) {
        super("Can not save worker" + id);
    }
}
