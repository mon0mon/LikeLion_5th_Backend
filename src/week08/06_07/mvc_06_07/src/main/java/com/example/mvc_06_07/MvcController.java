package com.example.mvc_06_07;

import com.example.mvc_06_07.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    private int hitCount = 0;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute(
            "message",
            "Hello, Thymeleaf!"
        );
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) {
        model.addAttribute(
            "object",
            new Student("Minki Lee", "mon0mon@naver.com")
        );

        return "student";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute(
            "isLoggedIn",
            true
        );
        return "if-unless";
    }

    @RequestMapping("/each")
    public String items(Model model) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");

        model.addAttribute(
            "listOfStrings",
            listOfStrings
        );

        List<Student> studentList = Arrays.asList(
            new Student("Alex", "alex@example.com"),
            new Student("Brad", "bard@example.com"),
            new Student("Chad", "chad@example.com")
        );
        model.addAttribute("studentList", studentList);

        return "each";
    }

    @RequestMapping("/hits")
    public String hit(Model model) {
        model.addAttribute("hits", ++hitCount);

        return "hits";
    }
}
