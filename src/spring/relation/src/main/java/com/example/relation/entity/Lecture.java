/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 1:13
 */

package com.example.relation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor")
    private Instructor instructor;

    @ManyToMany(mappedBy = "attending")
    private List<Student> students;

    private String name;
    private String day;
    private Integer startTime;
    private Integer endTime;

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", instructor=" + instructor +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
