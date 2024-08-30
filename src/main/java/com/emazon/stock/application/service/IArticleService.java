package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.ArticleRequest;
import com.emazon.stock.application.dto.ArticleResponse;
import com.emazon.stock.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticleService {
    ArticleResponse save(ArticleRequest article);
    Page<ArticleResponse> findAllArticles(int page, int size, String sortDirection, String sortField);
}
