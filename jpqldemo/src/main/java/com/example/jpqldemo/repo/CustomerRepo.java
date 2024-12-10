package com.example.jpqldemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpqldemo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    // save
    // find
    // findAll()

    // custom methods with custom queries

    // all table names will be the class names in the entity class
    // all column names will be the field / member names in the entity class

    // @Query Annotation using the positional parameters
    @Query("select c from Customer c where lower(custName) = ?1")
    List<Customer> findByCustName(String custName);

}
