package com.example.multicontroller.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts") // a prefix for the endpoints in this controller
public class AccountController {
    @RequestMapping("/list")
    public String viewAccts() {
        return "List of accounts";
    }

    @RequestMapping("/add")
    public String addAcct() {
        return "Account add screen";
    }

    @RequestMapping("/edit")
    public String editAcct() {
        return "Account edit screen";
    }

    @RequestMapping("/delete")
    public String delAcct() {
        return "Account delete screen";
    }

}
