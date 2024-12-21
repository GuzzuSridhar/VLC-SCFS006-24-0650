package com.example.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("prod")
@RestController
public class ProdController {
    @RequestMapping("/")
    public String showMain() {
        return "Production environment applied ";
    }
}
