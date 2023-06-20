/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-20 0020 : PM 1:36
 */

package com.example.http.dto;

import java.util.List;
import lombok.Data;

@Data
public class ArticleComplexDto {
    private String title;
    private String content;
    private WriterDto writer;
    private List<String> comments;
}
