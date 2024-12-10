package com.example.jpaform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jpaform.model.Student;
import com.example.jpaform.repo.StudentRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/add")
    public String showAdd() {
        return "addform";
    }

    @PostMapping("/add")
    public String saveStud(@RequestParam int id,
            @RequestParam String name,
            @RequestParam double math,
            @RequestParam double eng) {

        studentRepo.save(new Student(id, name, eng, math, id));
        return "redirect:/list";
    }

}
