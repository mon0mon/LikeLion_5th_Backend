/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-14 : PM 1:29
 */

package com.example.jpa.repos;

import com.example.jpa.entities.StudentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    // SELECT * FROM students ORDER BY name
    List<StudentEntity> findAllByOrderByName();

    // SELECT * FROM students ORDER BY age DESC;
    List<StudentEntity> findAllByOrderByAgeDesc();

    //  SELECT * FROM students WHERE age < 21;
    List<StudentEntity> findAllByAgeLessThan(Integer age);

    //  SELECT * FROM students WHERE phone LIKE '010-%';
    List<StudentEntity> findAllByPhoneStartingWith(String phone);
}
