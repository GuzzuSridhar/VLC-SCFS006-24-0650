package com.example.h2jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
