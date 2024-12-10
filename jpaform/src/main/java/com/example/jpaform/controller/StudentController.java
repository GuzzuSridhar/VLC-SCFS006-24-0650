package com.example.jpaform.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
            @RequestParam double eng,
            @RequestParam int grade) {

        studentRepo.save(new Student(id, name, eng, math, grade));
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Optional<Student> stuOptional = studentRepo.findById(id);
        model.addAttribute("stud", stuOptional.get());
        return "editform";
    }

    @GetMapping("/delete/{id}")
    public String delStud(@PathVariable int id) {
        studentRepo.deleteById(id);
        return "redirect:/list";
    }

}
