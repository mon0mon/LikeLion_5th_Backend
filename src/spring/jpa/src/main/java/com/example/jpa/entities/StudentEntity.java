/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-14 : AM 11:34
 */

package com.example.jpa.entities;

/* CREATE TABLE students (
* id INTEGER PRIMARY KEY AUTOINCREAMENT,
* name TEXT,
* age INTEGER,
* phone TEXT,
* email TEXT
* */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Value;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //  Column 어노테이션에 인자를 전달해서 테이블 Constraint 추가 가능
//    @Column(name = "username", nullable = false)
    private String name;
    private Integer age;
    private String phone;
    private String email;
}
