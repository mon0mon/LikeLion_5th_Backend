package com.example.crud_06_08;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    //  복수의 StudentDto를 담는 변수
    private List<StudentDto> dtoList = new ArrayList<>();
    //  새로운 StudentDto를 생성하는 메소드
    private long id = 1L;
    public StudentDto createStudent(String name, String email) {
        StudentDto studentDto = new StudentDto(id++, name, email);
        dtoList.add(studentDto);

        return studentDto;
    }

    public List<StudentDto> readAllStudent() {
        return dtoList;
    }
}
