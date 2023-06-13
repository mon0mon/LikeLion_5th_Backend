/**
 * @project LikeLion_Backend
 * @author ARA on 2023-06-13 : PM 5:53
 */

package com.example.mybatis.model;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
}
