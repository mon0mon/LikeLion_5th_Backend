/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-07 PM 3:45
 */

package com.example.auth.jwt;

import lombok.Data;

@Data
public class JwtRequestDto {
    private String username;
    private String password;
}
