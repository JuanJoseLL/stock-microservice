package com.emazon.stock.application.usecases;

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
        return null;
    }

    @Override
    public Page<Article> findAllArticles(Pageable pageable) {
        return null;
    }


    private void validateArticleCategories(Article article) {
        String[] categoryIds = article.getCategory_id();

        if (categoryIds == null || categoryIds.length == 0) {
            throw new IllegalArgumentException("The Article must have at least one category associated.");
        }

        if (categoryIds.length > 3) {
            throw new IllegalArgumentException("The Article can have a maximum of 3 categories.");
        }

        Set<String> uniqueCategoryIds = new HashSet<>();
        for (String categoryId : categoryIds) {
            if (!uniqueCategoryIds.add(categoryId)) {
                throw new IllegalArgumentException("The Article cannot have duplicate categories.");
            }
        }
    }

}
