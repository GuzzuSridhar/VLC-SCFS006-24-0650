package com.example.jpaform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaform.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
