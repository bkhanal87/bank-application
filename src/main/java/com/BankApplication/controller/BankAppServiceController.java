package com.BankApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import com.BankApplication.model.User;
import com.BankApplication.service.BankService;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

// @RestController is used to define the RESTful web services
@RestController
public class BankAppServiceController {
    // here, we need to inject the service class using @Autowired method
    @Autowired
    private BankService bankService;

    // GET API to fetch a list of users
    @GetMapping("/users")
    public List<User> getUserList() {

        return bankService.getUserList();
    }

    // GET API to fetch user by id
    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") Long id) {

        return bankService.fetchUserById(id);
    }

    // PUT API
    @PutMapping ("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return bankService.updateUser(id, user);
    }

    // Delete API
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        bankService.deleteUserById(id);
        return "Department successfully deleted!";
    }

    // POST API
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
          return bankService.createUser(user);
    }
}




