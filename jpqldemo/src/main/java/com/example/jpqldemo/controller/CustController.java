package com.example.jpqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpqldemo.model.Customer;
import com.example.jpqldemo.repo.CustomerRepo;

@RestController
public class CustController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/findname")
    public List<Customer> findByname(String name) {
        return customerRepo.findByCustName(name);
    }

    @GetMapping("/findc")
    public Customer findcust(int id) {
        return customerRepo.findc(id);
    }

    @GetMapping("/findb")
    public List<Customer> finList(String name) {
        return customerRepo.findDistinctBycustName(name);
    }
}
