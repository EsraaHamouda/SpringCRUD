package com.tags.task;

public class GeneralExceptionHandler extends RuntimeException {

    public GeneralExceptionHandler(Long id) {
        super("Wrong Url " + id);
    }

}
