package com.example.testmanytoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testmanytoone.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
