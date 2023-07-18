/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 2:51
 */

package com.example.relation.repo;

import com.example.relation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
