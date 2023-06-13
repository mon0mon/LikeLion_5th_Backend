package com.example.crud_06_09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/home")
    public String redirectToHome() {
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String read(
        @PathVariable("id") Long id,
        Model model) {
        model.addAttribute(
            "student",
            studentService.readStudent(id)
        );
        return "read";
    }

    @GetMapping("/{id}/update-view")
    public String updateView(Model model,
        @PathVariable("id") Long id) {
        model.addAttribute("student",
            studentService.readStudent(id));

        return "update";
    }

    @PostMapping("/{id}/update-view")
    public String updateViewComplete(
        @PathVariable("id") Long id,
        @RequestParam("name") String name,
        @RequestParam("email") String email
        ) {

        studentService.updateStudent(id, name, email);

        return "redirect:/";
    }

    @GetMapping("/{id}/delete-view")
    public String deleteView(
        @PathVariable("id") Long id,
        Model model
    ) {
        StudentDto studentDto = studentService.readStudent(id);
        model.addAttribute("student", studentDto);
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(
        @PathVariable("id") Long id
    ) {
        studentService.deleteStudent(id);

        return "redirect:/home";
    }
}
