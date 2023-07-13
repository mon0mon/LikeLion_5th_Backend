/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-12 PM 2:19
 */

package com.example.producer.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {
    Optional<JobEntity> findByJobId(String jobId);
}
