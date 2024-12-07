package com.example.httpmethodform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpController {

    @GetMapping("/")
    public String showMain() {
        return "index";
    }

    @GetMapping("/list")
    public String getMethod(Model model) {
        model.addAttribute("getmsg", "Get Method");
        return "index";
    }

    @PostMapping("/add")
    public String postMethod(Model model) {
        model.addAttribute("postmsg", "Post Method");
        return "index";
    }

    @PutMapping("/edit")
    @ResponseBody // this ensures that the template name is not returned but a plain text or json
    public String putMethod(Model model) {
        // model.addAttribute("putmsg", "Put Method");
        return "Put Message from Controller";
        // return "index";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delMethod(Model model) {
        // model.addAttribute("delmsg", "Delete Method");
        return "Delete Message from";
    }
}
