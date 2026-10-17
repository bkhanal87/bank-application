package com.BankApplication.service;

import com.BankApplication.db.AccountRepository;
import com.BankApplication.db.UserRepository;
import com.BankApplication.model.Account;
import com.BankApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Account fetchAccountById ( int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAccountById(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account updateAccount(int id, Account account) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account accountDB = optionalAccount.get();

            // Assuming Account has these fields; change them to match your Account model variables
            if (Objects.nonNull(account.getAccountNumber()) && !account.getAccountNumber().trim().isEmpty()) {
                accountDB.setAccountNumber(account.getAccountNumber());
            }
            if (Objects.nonNull(account.getAccountType()) && !account.getAccountType().trim().isEmpty()) {
                accountDB.setAccountType(account.getAccountType());
            }
            if (account.getBalance() != 0) { // Example for primitive double/int balance fields
                accountDB.setBalance(account.getBalance());
            }

            return accountRepository.save(accountDB);
        }
        return null;
    }

}