package com.example.articleskeleton;

import com.example.articleskeleton.dto.ArticleDto;
import com.example.articleskeleton.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleDto createArticle(ArticleDto dto) {
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setWriter(dto.getWriter());

        entity = repository.save(entity);

        return ArticleDto.fromEntity(entity);
    }

    public ArticleDto readArticle(Long id) {
        return ArticleDto.fromEntity(
            repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public List<ArticleDto> readArticleAll() {
        return repository.findAll().stream()
            .map(ArticleDto::fromEntity)
            .toList();
    }

    public ArticleDto updateArticle(Long id, ArticleDto dto) {
        ArticleEntity entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setWriter(dto.getWriter());

        entity = repository.save(entity);

        return ArticleDto.fromEntity(entity);
    }

    public void deleteArticle(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);
    }

//    public List<ArticleDto> readArticlePaged() {
//        return repository.findTop20ByOrderByIdDesc()
//            .stream()
//            .map(ArticleDto::fromEntity)
//            .toList();
//    }

//    public List<ArticleDto> readArticlePaged() {
//        Pageable pageable = PageRequest.of(0, 20, Sort.by("id").descending());
//        Page<ArticleEntity> articleEntityPage = repository.findAll(pageable);
//
//        return articleEntityPage.stream().map(ArticleDto::fromEntity).toList();
//    }

    public Page<ArticleDto> readArticlePaged(Integer pageNumber, Integer limit) {
        Pageable pageable = PageRequest.of(pageNumber, limit, Sort.by("id").descending());

        return repository.findAll(pageable)
            .map(ArticleDto::fromEntity);
    }

    public Page<ArticleDto> search(String query, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 20, Sort.by("id").descending());
        return repository.findAllByTitleContains(query, pageable)
            .map(ArticleDto::fromEntity);
    }
}
