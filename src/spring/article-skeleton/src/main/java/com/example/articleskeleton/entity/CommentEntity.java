/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-21 0021 : PM 3:04
 */

package com.example.articleskeleton.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/*
id integer primary key autoincrement
writer text
content text
 */
@Data
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String content;
    @ManyToOne
    private ArticleEntity article;
}
