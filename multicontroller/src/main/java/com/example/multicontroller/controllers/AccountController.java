package com.example.multicontroller.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts") // a prefix for the endpoints in this controller
public class AccountController {
    @RequestMapping("/list") // is read as /accounts/list
    public String viewAccts() {
        return "List of accounts";
    }

    @RequestMapping("/add") // is read as /accounts/add
    public String addAcct() {
        return "Account add screen";
    }

    @RequestMapping("/edit") // is read as /accounts/edit
    public String editAcct() {
        return "Account edit screen";
    }

    @RequestMapping("/delete") // is read as /accounts/delete
    public String delAcct() {
        return "Account delete screen";
    }

}
