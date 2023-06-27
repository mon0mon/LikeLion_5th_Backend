package com.example.articleskeleton;

import com.example.articleskeleton.dto.ArticleDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService service;

    // POST /articles
    @PostMapping()
    public ArticleDto create(@RequestBody ArticleDto dto) {
        ArticleDto createdDto = service.createArticle(dto);
        log.info("POST /articles" + createdDto);
        return createdDto;
    }

    // GET /articles
    @GetMapping
    public List<ArticleDto> readAll(
        @RequestParam(value="page", defaultValue = "0") Integer pageNum,
        @RequestParam(value="limit", defaultValue = "20") Integer limit
    ) {
        return service.readArticlePaged(pageNum, limit)
            .stream()
            .toList();
    }

    // GET /articles/{id}
    @GetMapping("/{id}")
    public ArticleDto read(@PathVariable("id") Long id) {
        return service.readArticle(id);
    }

    // PUT /articles/{id}
    @PutMapping("/{id}")
    public ArticleDto update(@PathVariable("id") Long id, @RequestBody ArticleDto dto) {
        return service.updateArticle(id, dto);
    }

    // DELETE /articles/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteArticle(id);
    }

    //  GET /articles/page-test
    @GetMapping("/page-test")
    public Page<ArticleDto> readPageTest() {
        return service.readArticlePaged(0, 20);
    }

    //  GET /articles/search
    @GetMapping("/search")
    public Page<ArticleDto> search(
        @RequestParam("query") String query,
        @RequestParam(value = "page", defaultValue = "0") Integer page
    ) {
        return service.search(query, page);
    }
}
