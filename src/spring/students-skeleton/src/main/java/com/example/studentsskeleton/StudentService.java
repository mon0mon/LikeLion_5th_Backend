package com.example.studentsskeleton;

import com.example.studentsskeleton.dto.StudentDto;
import com.example.studentsskeleton.entity.StudentEntity;
import com.example.studentsskeleton.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    // CREATE
    public StudentDto createStudent(String name, Integer age, String phone, String email) {
        StudentEntity entity = new StudentEntity();
        entity.setName(name);
        entity.setAge(age);
        entity.setPhone(phone);
        entity.setEmail(email);
        entity = repository.saveAndFlush(entity);

        return StudentDto.getInstance(entity);
    }

    // READ
    public StudentDto readStudent(Long id) {
        return StudentDto.getInstance(
            repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    // READ ALL
    public List<StudentDto> readStudentAll() {
        return repository.findAll()
            .stream()
            .map(StudentDto::getInstance)
            .toList();
    }

    // UPDATE
    public StudentDto updateStudent(Long id, String name, Integer age, String phone, String email) {
        StudentEntity entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (entity == null) {
            return new StudentDto();
        }

        entity.setName(name);
        entity.setAge(age);
        entity.setPhone(phone);
        entity.setEmail(email);

        entity =repository.saveAndFlush(entity);

        return StudentDto.getInstance(entity);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
