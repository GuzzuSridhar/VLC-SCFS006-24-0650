package com.example.cssandjs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/test")
    public String testStatic() {
        return "testStatic";
    }
}
