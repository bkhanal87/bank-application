package com.BankApplication.service;

import com.BankApplication.model.User;
import com.BankApplication.model.Account;
import java.util.Collection;
import java.util.List;

// create an interface that add, edit, get, and delete users
public interface AccountService {
    public Account createAccount(Account account);

    public List<Account> getAccountList();

    public Account fetchAccountById(int id);

    public void deleteAccountById(int id);

    public Account updateAccount(int id, Account account);

    List<User> getUserList();
}


