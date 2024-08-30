package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.PageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticleServicePort {
    Article save(Article article);

    PageModel<Article> findAllArticles(int page, int size, String sortDirection, String sortField);
}
