/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-15 : PM 1:40
 */

package com.example.studentsskeleton.repository;


import com.example.studentsskeleton.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
