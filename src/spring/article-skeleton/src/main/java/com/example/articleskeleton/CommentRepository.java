/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-21 0021 : PM 3:22
 */

package com.example.articleskeleton;

import com.example.articleskeleton.entity.CommentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    //  CommentEntity 중 articleId가
    //  id인 CommentEntity 만 반환하는 메소드
    List<CommentEntity> findAllByArticleId(Long articleId);
}
