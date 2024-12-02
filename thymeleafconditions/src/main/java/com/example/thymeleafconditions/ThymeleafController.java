package com.example.thymeleafconditions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {
    @RequestMapping("/testage")
    public String showTest(Model m,
            @RequestParam("name") String n, @RequestParam("age") int x) {
        m.addAttribute("age", x);
        m.addAttribute("name", n);
        return "welcome";
    }
}
