/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-22 0022 : AM 11:05
 */

package com.example.articleskeleton;

import com.example.articleskeleton.dto.CommentDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/articles/{articleId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    // POST /articles/{articleId}/comments
    @PostMapping
    public CommentDto create(
        @PathVariable("articleId") Long articleId,
        @RequestBody CommentDto dto
    ) {
        return service.createComment(articleId, dto);
    }

    //  TODO 게시글 댓글 전체 조회
    //  GET /articles/{articleId}/comments
    @GetMapping
    public List<CommentDto> readAll(@PathVariable("articleId") Long articleId) {
        return service.readArticleComments(articleId);
    }

    //  TODO 게시글 댓글 수정
    //  PUT /articles/{articleId}/comments/{commentId}
    @PutMapping("/{commentId}")
    public CommentDto update(
        @PathVariable("articleId") Long articleId,
        @PathVariable("commentId") Long commentId,
        @RequestBody CommentDto commentDto
    ) {
        return service.updateComment(articleId, commentId, commentDto);
    }

    //  TODO 게시글 댓글 삭제
    //  DELETE /articles/{articleId}/comments/{commentId}
    @DeleteMapping("/{commentId}")
    public void delete(@PathVariable("commentId") Long commentId) {
        service.deleteComment(commentId);
    }
}
