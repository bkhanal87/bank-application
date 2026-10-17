package com.BankApplication.service;

import com.BankApplication.db.UserRepository;
import com.BankApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BankApplication.db.AccountRepository;
import com.BankApplication.model.Account;

import java.util.*;

// a service class needs to have @Service annotation
// this class is implementing the BankService interface
// write logic to create, update, delete, and get users here
@Service
public class BankServiceImpl implements BankService {
    // inject UserRepository here
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

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

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

   // fetch user by id
   public User fetchUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(
               "User not found with id: " + id
       ));
   }

   // delete user by id
   public void deleteUserById(int id) {
        userRepository.deleteById(id);
   }

    // update user by id
    public User updateUser(int id, User user) {

        User userDB = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (user.getName() != null && !user.getName().isBlank()) {
            userDB.setName(user.getName());
        }

        if (user.getAddress() != null && !user.getAddress().isBlank()) {
            userDB.setAddress(user.getAddress());
        }

        if (user.getPhoneNumber() != null && !user.getPhoneNumber().isBlank()) {
            userDB.setPhoneNumber(user.getPhoneNumber());
        }

        return userRepository.save(userDB);
    }
}
