package com.example.testmanytoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testmanytoone.model.Account;
import com.example.testmanytoone.repo.AccountRepo;
import com.example.testmanytoone.repo.CustRepo;

@RestController
public class CrudControl {

    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CustRepo custRepo;

    @GetMapping("/add")
    public void addAccount() {
        Account test = new Account(102, "abc1", 100, custRepo.findById(100L).orElseThrow());
        accountRepo.save(test);
    }
}
