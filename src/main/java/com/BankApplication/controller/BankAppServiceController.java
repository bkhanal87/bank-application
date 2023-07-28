package com.BankApplication.controller;

import com.BankApplication.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import com.BankApplication.model.User;
import com.BankApplication.service.BankService;

import java.util.HashMap;
import java.util.Map;

// @RestController is used to define the RESTful web services
@RestController
public class BankAppServiceController {
    // here, we need to inject the service class using @Autowired method
    @Autowired
    BankService bankService;
    // GET API
    // @RequestMapping used to define the Request URI to access the REST Endpoints
    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getUser() {
        return new ResponseEntity<>(bankService.getUsers(), HttpStatus.OK);
    }

    // PUT API
    // Exception handling added to put method
    // whenever client tries to update an id that doesn't exist
    // in the database, gets a message "user not found"
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        bankService.updateUser(id, user);
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }

    //DELETE API
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        bankService.deleteUser(id);
        return new ResponseEntity<>("Product is removed successfully", HttpStatus.OK);
    }

    // POST API
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        bankService.createUser(user);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
}




