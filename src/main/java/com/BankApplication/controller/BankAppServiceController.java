package com.BankApplication.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankuser")
public class BankAppServiceController {

    // GET Method to retrieve the user

    {
        public bankUser getbankUserDetails(String id) {
            return new bankUser("Customer1", "John Doe",
                    "123 Main Street, Anytown, Oh, 45022", "123-456-789");
    }
    }

}
