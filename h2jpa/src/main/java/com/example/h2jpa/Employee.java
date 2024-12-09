package com.example.h2jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // adds getters , setters, toString()
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private int id;
    private String name;
    private float sal;

}
