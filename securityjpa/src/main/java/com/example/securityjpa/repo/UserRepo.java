package com.example.securityjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securityjpa.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUserName(String name);

}
