/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-18 PM 2:42
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Lecture> attending;

    private String firstName;
    private String lastName;
}
