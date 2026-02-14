package com.BankApplication;


import com.BankApplication.db.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BankApp.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);
        // SpringApplication.run(BankApp.class, args);
    }
}
