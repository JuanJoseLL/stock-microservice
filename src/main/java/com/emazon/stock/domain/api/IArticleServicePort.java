package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticleServicePort {
    Article save(Article article);

    Page<Article> findAllArticles(Pageable pageable);
}
