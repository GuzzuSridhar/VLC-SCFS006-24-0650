package com.example.testmanytoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testmanytoone.model.Customer;

public interface CustRepo extends JpaRepository<Customer, Long> {

}
