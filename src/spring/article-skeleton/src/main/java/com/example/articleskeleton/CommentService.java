/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-21 0021 : PM 3:28
 */

package com.example.articleskeleton;

import com.example.articleskeleton.dto.ArticleDto;
import com.example.articleskeleton.dto.CommentDto;
import com.example.articleskeleton.entity.CommentEntity;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentDto createComment(Long articleId, CommentDto dto) {
        //  articleId를 ID로 가진 articleEntity가 존재 하는지?
        if (!articleRepository.existsById(articleId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        CommentEntity newComment = new CommentEntity();
        newComment.setArticle(articleRepository.findById(articleId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        newComment.setContent(dto.getContent());
        newComment.setWriter(dto.getWriter());
        newComment = commentRepository.save(newComment);
        return CommentDto.fromEntity(newComment);
    }

    //  TODO 게시글 댓글 전체 조회
    public List<CommentDto> readArticleComments(Long articleId) {
        List<CommentEntity> comments = commentRepository.findAllByArticleId(articleId);

        if (comments.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return comments.stream().map(CommentDto::fromEntity).toList();
    }

    //  TODO 게시글 댓글 수정
    public CommentDto updateComment(Long articleId, Long commentId, CommentDto dto) {
        //  요청한 댓글이 존재하는지
        //  존재하지 않으면 예외 발생
        CommentEntity entity = commentRepository.findById(commentId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        //  대상 댓글이 대상 게시글 댓글이 맞는지
        if (!entity.getArticle().getId().equals(articleId))
            //  대상 게시글 댓글이 아닌 경우 예외 발생
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        entity.setContent(dto.getContent());

        return CommentDto.fromEntity(commentRepository.save(entity));
    }


    //  TODO 게시글 댓글 삭제
    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        commentRepository.deleteById(commentId);
    }
}
