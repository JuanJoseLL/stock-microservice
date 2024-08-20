package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticlePersistancePort {
    Article save(Article article);
    Page<Article> findAllArticles(Pageable pageable);

}
