package com.BankApplication.service;

import com.BankApplication.model.User;
import java.util.Collection;

// create an interface that contains add, edit, get, and delete methods
public interface BankService {
    public abstract void createUser(User user);
    public abstract void updateUser(String id, User user);

    public abstract void deleteUser(String id);
    public abstract Collection<User> getUsers();
}

