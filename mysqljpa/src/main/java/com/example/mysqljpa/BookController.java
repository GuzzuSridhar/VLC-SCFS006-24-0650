package com.example.mysqljpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @GetMapping("/list")
    public List<Book> showBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/list/{id}")
    public Book showOneBook(@PathVariable("id") int id) {
        return bookRepo.findById(id).get();
    }

    @RequestMapping("/add")
    public void addBook(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("price") float price) {
        Book newEmployee = new Book(id, name, price);
        bookRepo.save(newEmployee);
    }

    @RequestMapping("/delete/{id}")
    public void delEmp(@PathVariable("id") int id) {
        bookRepo.deleteById(id);
    }
}
