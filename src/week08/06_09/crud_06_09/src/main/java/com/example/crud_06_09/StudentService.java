package com.example.crud_06_09;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //  복수의 StudentDto를 담는 변수
    private List<StudentDto> dtoList = new ArrayList<>();
    //  새로운 StudentDto를 생성하는 메소드
    private long id = 1L;

    public StudentService() {
        createStudent("mon0mon", "mon0mon@naver.com");
        createStudent("user", "user@example.com");
        createStudent("test", "test@example.com");
    }

    public StudentDto createStudent(String name, String email) {
        StudentDto studentDto = new StudentDto(id++, name, email);
        dtoList.add(studentDto);

        return studentDto;
    }

    public List<StudentDto> readAllStudent() {
        return dtoList;
    }

    public StudentDto readStudent(Long id) {
        for (int i = 0; i < dtoList.size(); i++) {
            if (dtoList.get(i).getId().equals(id)) {
                return dtoList.get(i);
            }
        }

        return null;
    }

    public StudentDto updateStudent(Long id, String name, String email) {
        for (int i = 0; i < dtoList.size(); i++) {
            if (dtoList.get(i).getId().equals(id)) {
                StudentDto studentDto = dtoList.get(i);
                studentDto.setName(name);
                studentDto.setEmail(email);
                dtoList.set(i, studentDto);

                return studentDto;
            }
        }

        return null;
    }

    public boolean deleteStudent(Long id) {
        for (int i = 0; i < dtoList.size(); i++) {
            if (dtoList.get(i).getId().equals(id)) {
                dtoList.remove(i);
                return true;
            }
        }

        return false;
    }
}
