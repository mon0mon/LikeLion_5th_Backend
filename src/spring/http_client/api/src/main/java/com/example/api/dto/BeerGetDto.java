/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-07-05 PM 1:21
 */

package com.example.api.dto;

import lombok.Data;

@Data
public class BeerGetDto {
    private Long id;
    private String uid;
    private String brand;
    private String name;
    private String style;
    private String hop;
    private String yeast;
    private String malts;
    private String ibu;
    private String alcohol;
    private String blg;
}
