package com.example.jpaannotations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity // creates a table with the name of the class
@Table(name = "anything") // name the table in db seperately from the class name
public class Student {
    @Id // used to create a primary key column
    @Column(name = "stud_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the columnm will generate value imlicitly and shoold not be
                                                        // included in the instert statement
    private int id;
    @Column(nullable = false, unique = false)
    private String name;
    private double marks;
    @Transient
    private boolean test;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

}

/*
 * @Column annotation
 * is used to add additional parameters to the column
 * additional parameters list
 * name -- set a custom name to the column
 * length -- specify a length of the data for the column
 * nullable -- (true/false) specifies if the column can have null values
 * unique -- (true/false) specifies if the column can have duplicate values
 * precision & scale -- used to secify the length for bigdecimal value columns
 * 
 * @Transient -- ignore the field from being added as a column in the database
 * 
 */