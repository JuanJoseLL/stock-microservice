package com.emazon.stock.infrastructure.out.jpa.mapper;

import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;
import com.emazon.stock.infrastructure.out.jpa.repository.IBrandRepository;
import com.emazon.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ArticleEntityMapperDecorator implements ArticleEntityMapper{

    private final ICategoryRepository categoryRepository;
    private final IBrandRepository brandRepository;

    public ArticleEntityMapperDecorator(ICategoryRepository categoryRepository, IBrandRepository brandRepository) {
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public ArticleJPA toEntity(Article article) {
        if (article == null) return null;

        ArticleJPA itemEntity = new ArticleJPA();

        itemEntity.setId(article.getId());

        itemEntity.setPrice(article.getPrice());
        itemEntity.setStock(article.getStock());

        if (article.getBrand() != null){
            Optional<BrandJPA> brandEntity = brandRepository.findByName(article.getBrand().getName());

            brandEntity.ifPresent(itemEntity::setBrand);
        }

        Set<Category> categories = article.getCategory();

        Set<CategoryJPA> categoryEntities = categories.stream().map(category -> {
            Optional<CategoryJPA> categoryEntity = categoryRepository.findByName(category.getName());
            return categoryEntity.orElse(null);
        }).collect(Collectors.toSet());

        itemEntity.setCategories(categoryEntities);



        return itemEntity;
    }

    @Override
    public Article toArticle(ArticleJPA articleJPA) {
        if (articleJPA == null) return null;

        Article builder = new Article();

        builder.setId(articleJPA.getId());
        builder.setStock(articleJPA.getStock());
        builder.setPrice(articleJPA.getPrice());

        Set<Category> categoryEntities = articleJPA.getCategories().stream()
                .map(categoryEntity -> new Category(
                        categoryEntity.getId(),
                        categoryEntity.getName(),
                        categoryEntity.getDescription())
                ).collect(Collectors.toSet());

        builder.setCategory(categoryEntities);

        if (articleJPA.getBrand() != null){
            builder.setBrand(new Brand(
                    articleJPA.getBrand().getId(),
                    articleJPA.getBrand().getName(),
                    articleJPA.getBrand().getDescription()
            ));
        }
        return builder;
    }

    @Override
    public Page<Article> toItemsPage(Page<ArticleJPA> itemEntities) {
        List<Article> items = itemEntities
                .map(this::toArticle)
                .getContent();
        return new PageImpl<>(items, itemEntities.getPageable(), itemEntities.getTotalElements());
    }
}
