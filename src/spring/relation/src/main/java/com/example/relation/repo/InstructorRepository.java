/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 1:28
 */

package com.example.relation.repo;

import com.example.relation.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
