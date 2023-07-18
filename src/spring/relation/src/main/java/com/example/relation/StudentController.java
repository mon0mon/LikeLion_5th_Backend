/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 3:24
 */

package com.example.relation;

import com.example.relation.entity.Lecture;
import com.example.relation.entity.Student;
import com.example.relation.repo.LectureRepository;
import com.example.relation.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @PutMapping("{id}/lectures/{lectureId}")
    @Transactional
    public void updateStudentLectures(
            @PathVariable("id") Long id,
            @PathVariable("lectureId") Long lectureId
    ) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Lecture lecture = lectureRepository
                .findById(lectureId)
                .orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        student.getAttending().add(lecture);
    }
}
