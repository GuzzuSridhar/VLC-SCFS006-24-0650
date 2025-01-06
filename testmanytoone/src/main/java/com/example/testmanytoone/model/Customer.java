package com.example.testmanytoone.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public Customer() {
    }

    public Customer(long id, String name, String email, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accounts = accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
