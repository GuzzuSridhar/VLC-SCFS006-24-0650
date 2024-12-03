package com.example.crudbootstrap;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {
    ArrayList<Employee> employees = new ArrayList<>();

    // end point to display the list of employees
    @RequestMapping("/list")
    public String showEmployees(Model model) {
        model.addAttribute("emplist", employees);
        return "emp";
    }

    // end point to add employee
    @RequestMapping("/add")
    public String addEmployee(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("sal") float sal) {
        employees.add(new Employee(id, name, sal));
        return "redirect:/list";

    }

}
