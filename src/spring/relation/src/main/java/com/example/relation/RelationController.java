/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 1:35
 */

package com.example.relation;

import com.example.relation.entity.Instructor;
import com.example.relation.entity.Lecture;
import com.example.relation.repo.InstructorRepository;
import com.example.relation.repo.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("lectures")
@RequiredArgsConstructor
public class RelationController {
    private final LectureRepository lectureRepository;
    private final InstructorRepository instructorRepository;

    @PutMapping("{id}/instructor/{instructorId}")
    @Transactional
    public void updateLectureInstructor(
            @PathVariable("id") Long id,
            @PathVariable("instructorId") Long instructorId
    ) {
        Lecture lecture = lectureRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
        Instructor instructor = instructorRepository
                .findById(instructorId)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

        lecture.setInstructor(instructor);
    }


    @DeleteMapping("{id}")
    @Transactional
    public void deleteLectureInstructor(
            @PathVariable("id") Long id
    ) {
        Lecture lecture = lectureRepository
                .findById(id)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
        lecture.setInstructor(null);
    }

    @GetMapping("{id}/instructor")
    public void readLectureInstructor(
            @PathVariable("id") Long id
    ) {
        Lecture lecture = lectureRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

        Instructor instructor = lecture.getInstructor();

        if (Objects.isNull(instructor))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        log.info(instructor.toString());
    }
}
