/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-21 0021 : PM 3:04
 */

package com.example.articleskeleton.dto;

import com.example.articleskeleton.entity.CommentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
id integer primary key autoincrement
writer text
content text
 */
@Data
public class CommentDto {
    private Long id;
    private Long articleId;
    private String writer;
    private String content;

    public static CommentDto fromEntity(CommentEntity entity) {
        CommentDto dto = new CommentDto();
        dto.setId(entity.getId());
        dto.setArticleId(entity.getArticle().getId());
        dto.setContent(entity.getContent());
        dto.setWriter(entity.getWriter());
        return dto;
    }
}
