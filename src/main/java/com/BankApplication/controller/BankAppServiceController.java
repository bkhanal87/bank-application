package com.BankApplication.controller;

import com.BankApplication.model.User;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BankAppServiceController {
    // GET Method to retrieve the user
    // add GETMapping here to map to the URL
    @GetMapping("{id}")
    // here, we are adding the hard coded values and mapping with the object in the model
    // this value will be dynamically obtained from the DB later
    public User getBankUserDetails(String id) {
        return new User("Customer1",
                "John Doe",
                "123 Main Street, Any Town, Oh, 45022",
                "123-456-789");
    }
}
