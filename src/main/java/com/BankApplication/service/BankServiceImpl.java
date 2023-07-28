package com.BankApplication.service;

import com.BankApplication.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// a service class needs to have @Service annotation
// this class is implementing the BankService interface
// write logic to create, update, delete, and get users here
@Service
public class BankServiceImpl implements BankService{
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
    // logic to create user
    // the override method isn't required but helps to prevent errors, if any
    @Override
    public void createUser(User user) {
        bankUser.put(user.getId(), user);
    }
    // update user
    @Override
    public void updateUser(String id, User user) {
        bankUser.remove(id);
        user.setId(id);
        bankUser.put(id, user);
    }

    // delete user
    @Override
    public void deleteUser(String id) {
        bankUser.remove(id);
    }
    // get user
    @Override
    public Collection<User> getUsers() {
        return bankUser.values();
    }
}
