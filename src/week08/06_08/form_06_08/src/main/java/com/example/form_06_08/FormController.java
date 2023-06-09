package com.example.form_06_08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
//    @RequestMapping(
//        value = "/send",
//        method = RequestMethod.GET
//    )
    @GetMapping("/send")
    public String getForm() {
        return "send";
    }

//    @RequestMapping(
//        value = "/receive",
//        method = RequestMethod.POST
//    )
    @PostMapping("/receive")
    public String receive(
        @RequestParam("msg")
        String msg,
        @RequestParam("email")
        String email
    ) {
        System.out.println(msg);
        System.out.println(email);
        return "send";
    }
}
