/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-13 : PM 6:09
 */

package com.example.mybatis.mapper;

import com.example.mybatis.mapper.provider.StudentProvider;
import com.example.mybatis.model.Student;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    // insert
    @Insert("INSERT INTO students(name, age, phone, email)\n" +
        "VALUES(#{name}, #{age}, #{phone}, #{email})")
    void insertStudent(Student student);

    @Insert("INSERT INTO students(name, age, phone, email)\n" +
        "VALUES(#{name}, #{age}, #{phone}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertStudentKeys(Student student);


    // select
    @Select("SELECT * FROM students")
    List<Student> selectStudentAll();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student selectStudent(Long id);

    // update
    @Update("UPDATE students SET " +
        "name = #{name}," +
        "age = #{age}," +
        "phone = #{phone}," +
        "email = #{email}" +
        "WHERE id = #{id}")
    void updateStudent(Student student);

    // delete
    @Delete("DELETE FROM students " +
        "WHERE id = #{id}")
    void deleteStudent(Long id);

    // select with optional
    @Select("SELECT * FROM students WHERE id = #{id}")
    Optional<Student> selectStudentOptional(Long id);

    // dynamic sql
    @SelectProvider(type = StudentProvider.class, method = "findByFields")
    List<Student> findByFields(Student student);

}