package com.BankApplication.service;

import com.BankApplication.db.UserRepository;
import com.BankApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// a service class needs to have @Service annotation
// this class is implementing the BankService interface
// write logic to create, update, delete, and get users here
@Service
public class BankServiceImpl implements BankService {
    // inject UserRepository here
    @Autowired
    private UserRepository userRepository;

    // logic to create user
    // the override method isn't required but helps to prevent errors, if any
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // fetch all users
    @Override
   public List<User> getUserList() {
        return userRepository.findAll();
   }

   // fetch user by id
   public User fetchUserById(Long id) {
        return userRepository.findById(id).get();
   }

   // delete user by id
   public void deleteUserById(Long id) {
        userRepository.deleteById(id);
   };

    // update user by id
    public User updateUser(Long id, User user) {
        User userDB = userRepository.findById(id).get();

        if(Objects.nonNull (user.getName()) &&
                !"".equalsIgnoreCase(user.getName())) {
            userDB.setName(user.getName());
        }

        if(Objects.nonNull (user.getAddress()) &&
                !"".equalsIgnoreCase(user.getAddress())) {
            userDB.setAddress(user.getAddress());
        }

        if(Objects.nonNull (user.getPhoneNumber()) &&
                !"".equalsIgnoreCase(user.getPhoneNumber())) {
            userDB.setPhoneNumber(user.getPhoneNumber());
        }

        return userRepository.save(userDB);
    }
}
