package com.example.testmanytoone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
    @Id
    private long id;
    private String accountNumber;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account() {
    }

    public Account(long id, String accountNumber, double balance, Customer customer) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
