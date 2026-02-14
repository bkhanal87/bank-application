package com.BankApplication.service;

import com.BankApplication.model.User;
import java.util.Collection;
import java.util.List;

// create an interface that add, edit, get, and delete users
public interface BankService {
    public User createUser(User user);

    public List<User> getUserList();

    public User fetchUserById(int id);

    public void deleteUserById(int id);

    public User updateUser(int id, User user);

}


