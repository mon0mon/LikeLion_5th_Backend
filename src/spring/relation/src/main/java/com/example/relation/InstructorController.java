/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 2:17
 */

package com.example.relation;

import com.example.relation.entity.Instructor;
import com.example.relation.entity.Lecture;
import com.example.relation.repo.InstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("instructor")
public class InstructorController {
    private final InstructorRepository instructorRepository;

    @GetMapping("{id}/lectures")
    public void readInstructorLectures(
            @PathVariable("id") Long id
    ) {
        Instructor instructor = instructorRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

        if (Objects.isNull(instructor.getLectures())
                || instructor.getLectures().isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        for (Lecture lecture : instructor.getLectures()) {
            log.info(lecture.getName());
        }
    }
}
