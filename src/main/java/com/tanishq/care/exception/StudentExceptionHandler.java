package com.tanishq.care.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public final ResponseEntity<Object> handleStudentException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(ex, HttpStatus.BAD_REQUEST);
    }
}
