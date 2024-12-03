package com.example.anchors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/page1")
    public String showOne() {
        return "pageone";
    }

    @RequestMapping("/page2")
    public String showTwo() {
        return "pagetwo";
    }

}
