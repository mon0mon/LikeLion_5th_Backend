/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 1:45
 */

package com.example.api.dto;

import lombok.Data;

@Data
public class BeerPostDto {
    private String name;
    private Long cc;
    private Double alcohol;
}
