package com.tanishq.care.exception;

public class StudentException extends RuntimeException {

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Exception e) {
        super(message, e);
    }

    public StudentException(Exception e) {
        super(e);
    }
}
