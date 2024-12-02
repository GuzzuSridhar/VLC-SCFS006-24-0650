package com.example.multicontroller.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction") // a prefix for the endpoints in this controller
public class TransactionController {
    @RequestMapping("/list")
    public String viewAccts() {
        return "List of Transactions";
    }

    @RequestMapping("/add")
    public String addAcct() {
        return "Transaction add screen";
    }

}
