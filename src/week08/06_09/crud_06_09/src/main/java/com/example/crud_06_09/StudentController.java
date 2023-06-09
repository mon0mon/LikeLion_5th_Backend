package com.example.crud_06_09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    //  StudentService를 Controller에서 사용
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create-view")
    public String createView() {
        return "create";
    }

    @PostMapping("/create")
    public String create(
        @RequestParam
        String name,
        @RequestParam
        String email
    ) {
        System.out.println(studentService.createStudent(name, email).toString());

//        return "redirect:/create-view";
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("studentList",
            studentService.readAllStudent());

        return "home";
    }

    @GetMapping("/read")
    public String read(
        @RequestParam("id")
        Long id,
        Model model) {
        model.addAttribute(
            "student",
            studentService.readStudent(id)
        );
        return "read";
    }
}
