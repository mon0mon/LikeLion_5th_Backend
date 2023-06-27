/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-27 PM 1:46
 */

package com.example.aop.controller;

import com.example.aop.aspect.LogArguments;
import com.example.aop.dto.ResponseDto;
import com.example.aop.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AopController {
    @PostMapping("/users")
    //  컨트롤러의 코드를 크게 바꾸지 않으면서
    //  부수적인 기능을 추가
    @LogArguments
    public ResponseDto addUser(@RequestBody UserDto user) {
        log.info(user.toString());
        ResponseDto response = new ResponseDto();
        response.setMessage("addUser");
        return response;
    }

    @GetMapping("/users")
    @LogArguments
    public ResponseDto getUsers() {
        ResponseDto response = new ResponseDto();
        response.setMessage("addUser");
        return response;
    }
}
