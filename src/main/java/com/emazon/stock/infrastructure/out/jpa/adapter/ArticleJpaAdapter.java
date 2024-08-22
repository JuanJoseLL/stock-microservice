package com.emazon.stock.infrastructure.out.jpa.adapter;


import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.spi.IArticlePersistancePort;
import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import com.emazon.stock.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.IArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistancePort {

    private final IArticleRepository articleRepository;

    private final ArticleEntityMapper articleEntityMapper;

    @Override
    public Article save(Article article) {
        ArticleJPA articleJpa = articleEntityMapper.toEntity(article);
        Article articleResponse = articleEntityMapper.toArticle(articleRepository.save(articleJpa));
        System.out.println(articleResponse);
        return articleResponse;
    }

    @Override
    public Page<Article> findAllArticles(Pageable pageable) {
        return null;
    }
}
