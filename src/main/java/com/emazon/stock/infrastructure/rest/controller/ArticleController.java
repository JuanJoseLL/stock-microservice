package com.emazon.stock.infrastructure.rest.controller;


import com.emazon.stock.application.dto.ArticleRequest;
import com.emazon.stock.application.dto.ArticleResponse;
import com.emazon.stock.application.service.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@AllArgsConstructor
public class ArticleController {

    private final IArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleResponse> saveArticle(@RequestBody ArticleRequest articleRequest) {
        ArticleResponse articleResponse = articleService.save(articleRequest);
        return new ResponseEntity<>(articleResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ArticleResponse>> findAllBrands(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "asc") String sortD,
            @RequestParam(defaultValue = "id") String sortF
    ) {
        Page<ArticleResponse> itemResponses = articleService.findAllArticles(page, size, sortD, sortF);
        return new ResponseEntity<>(itemResponses, HttpStatus.OK);
    }
}

