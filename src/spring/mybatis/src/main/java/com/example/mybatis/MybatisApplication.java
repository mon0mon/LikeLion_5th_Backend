package com.example.mybatis;

import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext
            = SpringApplication.run(MybatisApplication.class, args);

        StudentDao dao = applicationContext.getBean(StudentDao.class);
        dao.readStudentsAll().forEach(System.out::println);

        Student student = new Student();
        student.setName("dave");
        student.setAge(40);
        student.setPhone("010-1111-2222");
        student.setEmail("dave@naver.com");
        dao.createStudent(student); // 새로 set한 student 추가


        for (Long i = 1L; i <= 4L; i++) {
            System.out.println(dao.readStudent(i)); // i는 id값 , Student 한명씩 읽음
        }
    }

}
