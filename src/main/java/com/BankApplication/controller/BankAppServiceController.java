package com.BankApplication.controller;

import com.BankApplication.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// @RestController is used to define the RESTful web services
@RestController
public class BankAppServiceController {
    // GET API
    private static Map<String, User> bankUser = new HashMap<>();
    static {
        User user1 = new User();
        user1.setId("1");
        user1.setName("John");
        user1.setAddress("123 Main Street, Syracuse, NY 12345");
        user1.setPhoneNumber("123-456-789");
        bankUser.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId("2");
        user2.setName("Michael");
        user2.setAddress("456 Any Court, Anytown, Oh 45232");
        user2.setPhoneNumber("100-012-5342");
        bankUser.put(user2.getId(), user2);
    }
    // @RequestMapping used to define the Request URI to access the REST Endpoints
    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getUser() {
        return new ResponseEntity<>(bankUser.values(), HttpStatus.OK);
    }

    // PUT API
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        bankUser.remove(id);
        user.setId(id);
        bankUser.put(id, user);
        return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
    }

    //DELETE API
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        bankUser.remove(id);
        return new ResponseEntity<>("Product is removed successfully", HttpStatus.OK);
    }

    // POST API
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        bankUser.put(user.getId(), user);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
}




