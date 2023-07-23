package com.BankApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// the ControlAdvice class handles exceptions globally; whereas,
// @ExceptionHandler for a specific exception or custom responses
@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value = UserNotfoundException.class)
    public ResponseEntity<Object> exception(UserNotfoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}

