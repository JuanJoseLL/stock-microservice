package com.emazon.stock.infrastructure.rest.controller;


import com.emazon.stock.application.dto.ArticleRequest;
import com.emazon.stock.application.dto.ArticleResponse;
import com.emazon.stock.application.service.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
@AllArgsConstructor
public class ArticleController {

    private final IArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleResponse> saveArticle(@RequestBody ArticleRequest articleRequest) {
        System.out.println("Controller"+articleRequest);
        ArticleResponse articleResponse = articleService.save(articleRequest);
        System.out.println("Controller"+articleResponse);
        return new ResponseEntity<>(articleResponse, HttpStatus.CREATED);
    }
}

