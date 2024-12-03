package com.example.crudbootstrap;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

        boolean empExists = false;

        // check to see if the employee already exixts in the list
        for (Employee employee : employees) {
            if (employee.getEmpid() == id) {
                // if existing change the name and salary
                employee.setEname(name);
                employee.setSal(sal);
                empExists = true;
                break;
            }
        }
        if (!empExists)
            employees.add(new Employee(id, name, sal));
        return "redirect:/list";
    }

    // end point to update and employee
    @RequestMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, Model model) {
        System.out.println(id);
        model.addAttribute("emplist", employees);
        for (Employee employee : employees) {
            if (employee.getEmpid() == id) {
                model.addAttribute("editrec", employee);
                break;
            }
        }
        return "emp";
    }

    // end point to delete an employee
    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getEmpid() == id) {
                employees.remove(employee);
                break;
            }
        }
        return "redirect:/list";
    }
}
