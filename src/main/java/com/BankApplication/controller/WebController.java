package com.BankApplication.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// to redirect the Request URI to HTML file
@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
