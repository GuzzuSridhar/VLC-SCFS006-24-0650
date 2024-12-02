package com.example.customobject;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
    @RequestMapping("/emp")
    public String showEmpList(Model model) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100, "Alex", 1000));
        employees.add(new Employee(101, "Alice", 1011));
        employees.add(new Employee(102, "David", 1022));
        employees.add(new Employee(103, "Sara", 1033));
        model.addAttribute("list", employees);
        return "emp";

    }
}
