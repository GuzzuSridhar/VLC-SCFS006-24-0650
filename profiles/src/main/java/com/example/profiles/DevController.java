package com.example.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController
public class DevController {
    @RequestMapping("/")
    public String showMain() {
        return "Development environment applied ";
    }
}
