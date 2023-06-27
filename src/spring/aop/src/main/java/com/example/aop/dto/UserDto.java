/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-27 PM 1:43
 */

package com.example.aop.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String passwordCheck;
    private String email;
    private String phone;
}
