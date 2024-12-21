package com.example.securityjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityjpa.model.User;
import com.example.securityjpa.repo.RoleRepo;
import com.example.securityjpa.repo.UserRepo;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    // password encryption
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/")
    public String showRoot(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "welcome";
    }

    @PostMapping("/")
    public String showRoot1(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "welcome";
    }

    @GetMapping("/new")
    public String showAdd(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepo.findAll());
        return "newuser";
    }

    @GetMapping("/save")
    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String DelUser(@PathVariable("id") long id) {
        userRepo.deleteById(id);
        return "redirect:/";
    }

}
