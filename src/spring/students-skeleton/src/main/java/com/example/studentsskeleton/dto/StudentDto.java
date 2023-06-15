package com.example.studentsskeleton.dto;

import com.example.studentsskeleton.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;

    public static StudentDto getInstance(StudentEntity entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
