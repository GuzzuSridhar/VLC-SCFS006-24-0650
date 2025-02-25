package com.example.jpqldemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.jpqldemo.model.Customer;

import jakarta.transaction.Transactional;

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

    // @Query Annotation using the named parameters
    @Query("select c from Customer c where custId = :cid")
    Customer findc(int cid);

    // using the builin jpa method naming
    List<Customer> findDistinctBycustName(String name);

    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    // Native Queries
    // using the table and column names as in the database
    @Query(value = "select * from customer where cust_name= ?1", nativeQuery = true)
    List<Customer> findByName(String name);

    // updating records
    @Modifying
    @Transactional
    @Query("update Customer c set c.custName= :name where custId = :id")
    void setName(String name, int id);

    // deletion of records
    @Modifying
    @Transactional
    @Query("delete from Customer c  where c.custName=  :cname ")
    void deleteCustomer(String cname);
}
