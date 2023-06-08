package com.example.demo_06_07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }
}
