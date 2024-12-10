package com.example.jpaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jpaform.repo.StudentRepo;

@Controller
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/list")
    public String showStudents(Model model) {
        model.addAttribute("list", studentRepo.findAll());
        return "liststudents";
    }

}
