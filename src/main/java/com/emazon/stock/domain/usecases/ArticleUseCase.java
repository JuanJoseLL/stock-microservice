package com.emazon.stock.domain.usecases;

import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.IArticlePersistancePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Set;

public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistancePort articlePersistancePort;

    public ArticleUseCase(IArticlePersistancePort articlePersistancePort) {
        this.articlePersistancePort = articlePersistancePort;
    }


    @Override
    public Article save(Article article) {
        validateArticleCategories(article);

        return articlePersistancePort.save(article);
    }

    @Override
    public Page<Article> findAllArticles(Pageable pageable) {
        return null;
    }


    private void validateArticleCategories(Article article) {
        Set<Category> categories = article.getCategory();

        if (categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("The Article must have at least one category associated.");
        }

        if (categories.size() > 3) {
            throw new IllegalArgumentException("The Article can have a maximum of 3 categories.");
        }

        Set<Category> uniqueCategories = new HashSet<>();
        for (Category category : categories) {
            if (!uniqueCategories.add(category)) {
                throw new IllegalArgumentException("The Article cannot have duplicate categories.");
            }
        }
    }


}
