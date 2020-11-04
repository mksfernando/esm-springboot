package com.demo.esm.common;

public class ESMValidationException extends RuntimeException {
    public ESMValidationException(String message) {
        super(message);
    }

    public ESMValidationException(Throwable e) {
        super(e);
    }
}
