package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.ArticleRequest;
import com.emazon.stock.application.dto.ArticleResponse;
import com.emazon.stock.application.mapper.ArticleRequestMapper;
import com.emazon.stock.application.mapper.ArticleResponseMapper;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ArticleService implements IArticleService{

    private final IArticleServicePort articleServicePort;
    private final ArticleRequestMapper articleRequestMapper;
    private final ArticleResponseMapper articleResponseMapper;

    public ArticleService(IArticleServicePort articleServicePort, ArticleRequestMapper articleRequestMapper, ArticleResponseMapper articleResponseMapper) {
        this.articleServicePort = articleServicePort;
        this.articleRequestMapper = articleRequestMapper;
        this.articleResponseMapper = articleResponseMapper;
    }
    @Override
    public ArticleResponse save(ArticleRequest articleRequest) {
        Article article = articleRequestMapper.toArticle(articleRequest);
        articleServicePort.save(article);
        System.out.println("Service: "+article);
        return articleResponseMapper.toArticleResponse(article);
    }

    @Override
    public Page<Article> findAllArticles(Pageable pageable) {
        return null;
    }
}
