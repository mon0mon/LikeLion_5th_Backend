/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-14 : AM 9:33
 */

package com.example.jpa;

import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequiredArgsConstructor
//  모든 메소드에 @ResponseBody를 붙히는 용도
public class AppController {
    //  사용자의 입력을 받는 요소 (MVC패턴에서 Controller를 담당)
    private final AppService service;

    @GetMapping("create")
    public @ResponseBody String create() {
        service.createStudent("alex", 35, "010-1234-5678", "alex@gmail.com");

        return "done";
    }

    @GetMapping("read-all")
    public @ResponseBody String readAll() {
        service.readStudentAll();
        return "done-read-all";
    }

    @GetMapping("read/{id}")
    public @ResponseBody String readOne(
        @PathVariable("id") Long id
    ) {
        service.readStudent(id);
        return "done-read-one";
    }

    @GetMapping("update")
    public @ResponseBody String update() {
        service.updateStudent(1L, "alexander");
        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        service.findAllByTest();
        return "done-find";
    }

//    //  RequestMapping과 같이 사용
//    @RequestMapping("students")
//    public void students() {
//        List<Object> result = service.readStudentAll();
//    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("body")
    @ResponseBody
    public String body() {
        return "body";
    }
}
