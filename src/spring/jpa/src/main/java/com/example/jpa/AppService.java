/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-14 : AM 9:45
 */

package com.example.jpa;

import com.example.jpa.entities.StudentEntity;
import com.example.jpa.repos.StudentRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {
    //  JPA Repository
    private final StudentRepository studentRepository;

    //  주된 비즈니스 로직이 구현되는 공간
    //  Controller -> Service
    //  Service
    //  1. 데이터베이스 조회
    //  2. Component 사용
    //  3. 모은 데이터를 가지고 응답 (의사결정)

    //  CREATE
    public void createStudent(String name, Integer age, String phone, String email) {
        StudentEntity student = new StudentEntity();
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);

        studentRepository.save(student);
    }

    //  READ
    public void readStudent(Long id) {
        System.out.println(studentRepository.findById(id));
    }

    //  READ ALL
    public void readStudentAll() {
        System.out.println(studentRepository.findAll());
    }

    //  UPDATE
    public void updateStudent(Long id, String name) {
        //  수정함 Entity 회수
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        //  수정할 Entity를 찾은 경우
        if (optionalStudentEntity.isPresent()) {
            //  실제 객체 회수
            StudentEntity target = optionalStudentEntity.get();
            //  수정할 데이터 적용
            target.setName(name);
            //  save
            studentRepository.save(target);
        } else {
            //  없으면 없다고 알려줌
            System.out.println("could not find");
        }
    }

    //  DELETE
    public void deleteStudent(Long id) {
        Optional<StudentEntity> optionalEntity =
            this.studentRepository.findById(id);
        // 삭제할 엔티티를 찾은 경우
        if (optionalEntity.isPresent()) {
            StudentEntity studentEntity =
                optionalEntity.get();
            // 삭제
            this.studentRepository.delete(studentEntity);
        } else {
            System.out.println("could not find");
        }
    }

    //  findAllBy
    public void findAllByTest() {
        List<StudentEntity> studentEntities = studentRepository.findAllByOrderByName();
        System.out.println("findAllByOrderByName");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");
        studentEntities = studentRepository.findAllByOrderByAgeDesc();
        System.out.println("findAllByOrderByAgeDesc");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");
        studentEntities = studentRepository.findAllByAgeLessThan(21);
        System.out.println("findAllByAgeLessThan");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
        System.out.println("...");
        studentEntities = studentRepository.findAllByPhoneStartingWith("010-");
        System.out.println("findAllByPHoneStartingWith");
        for (int i = 0; i < 5; i++) {
            System.out.println(studentEntities.get(i));
        }
    }
}
