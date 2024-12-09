package com.example.h2jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    EmpRepo empRepo;

    @GetMapping("/list")
    public List<Employee> showEmp() {
        return empRepo.findAll();
    }

    @GetMapping("/list/{id}")
    public Employee showOneEmp(@PathVariable("id") int id) {
        return empRepo.findById(id).get();
    }

    @RequestMapping("/add")
    public void addEmployee(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("sal") float sal) {
        Employee newEmployee = new Employee(id, name, sal);
        empRepo.save(newEmployee);
    }
    /*
     * Update of a record is the same as the insert with the JPA
     * if the value for the id feild is the one that is existing in the database
     * then the update statement is executed. if the value for the id feild is new
     * then the insert is executed
     */

    @RequestMapping("/delete/{id}")
    public void delEmp(@PathVariable("id") int id) {
        empRepo.deleteById(id);
    }
}
