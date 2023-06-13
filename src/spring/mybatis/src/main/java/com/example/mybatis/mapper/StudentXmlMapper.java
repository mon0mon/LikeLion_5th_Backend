/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-13 : PM 6:14
 */

package com.example.mybatis.mapper;

import com.example.mybatis.model.Student;
import java.util.List;

public interface StudentXmlMapper {
    //  insert
    void insertStudent(Student student);
    void insertStudentKeys(Student student);

    //  select
    List<Student> selectStudentAll();
    Student selectStudent(Long id);

    //  update
    void updateStudent(Student student);

    //  delete
    void deleteStudent(Long id);

    //  dynamic sql
    List<Student> findByFields(Student student);
    void insertStudentBatch(List<Student> students);
}
