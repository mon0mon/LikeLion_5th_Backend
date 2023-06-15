package com.example.studentsskeleton.entity;
/* CREATE TABLE students (
*   id INTEGER PRIMARY KEY AUTOINCREMENT,
*   name TEXT,
*   age INTEGER,
*   phone TEXT,
*   email TEXT
* */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
}

