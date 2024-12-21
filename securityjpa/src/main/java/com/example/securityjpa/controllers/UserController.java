package com.example.securityjpa.controllers;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger("UserController.class");

    @GetMapping("/")
    public String showRoot(Model model) {
        List<User> users = userRepo.findAll();
        logger.info("Full User list queried from DB");
        model.addAttribute("users", users);
        return "welcome";
    }

    @PostMapping("/")
    public String showRoot1(Model model, Principal principal) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);

        logger.info(principal.getName() + " has logged in");

        return "welcome";
    }

    @GetMapping("/new")
    public String showAdd(Model model, Principal principal) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepo.findAll());
        logger.info(principal.getName() + " is attempting to create a  new User ");
        return "newuser";
    }

    @GetMapping("/save")
    public String saveUser(User user, Principal principal) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        logger.info(principal.getName() + " has Created a new User " + user.getUserName());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String DelUser(@PathVariable("id") long id, Principal principal) {
        userRepo.deleteById(id);
        logger.info(principal.getName() + " has deleted a user ");
        return "redirect:/";
    }

}
