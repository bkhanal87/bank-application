package com.BankApplication.controller;

import com.BankApplication.model.Account;
import com.BankApplication.model.User;
import com.BankApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAccountList();
    }

    @GetMapping("/accounts/{id}")
    public Account fetchAccountById(@PathVariable("id") int id) {
        return accountService.fetchAccountById(id);
    }

    @PutMapping ("/accounts/{id}")
    public Account updateAccount(@PathVariable("id") int id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/accounts/{id}")
    public String deleteAccountById(@PathVariable("id") int id) {
        accountService.deleteAccountById(id);
        return "account successfully deleted!";
    }
    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
}
