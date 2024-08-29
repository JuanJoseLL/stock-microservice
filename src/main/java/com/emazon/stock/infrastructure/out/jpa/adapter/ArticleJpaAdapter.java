package com.emazon.stock.infrastructure.out.jpa.adapter;


import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.IArticlePersistancePort;
import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;
import com.emazon.stock.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.IArticleRepository;
import com.emazon.stock.infrastructure.out.jpa.repository.IBrandRepository;
import com.emazon.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistancePort {

    private final IArticleRepository articleRepository;

    private final ArticleEntityMapper articleEntityMapper;
    private final IBrandRepository brandRepository;
    private final ICategoryRepository categoryRepository;
    private final BrandEntityMapper brandEntityMapper;
    private final CategoryEntityMapper categoryEntityMapper;
    @Override
    @Transactional
    public Article save(Article article) {
        BrandJPA brandJPA = brandRepository.findById(article.getBrand().getId())
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));

        Set<Long> categoryIds = article.getCategory().stream()
                .map(Category::getId)
                .collect(Collectors.toSet());
        List<CategoryJPA> categoriesJPA = categoryRepository.findAllById(categoryIds);

        if (categoriesJPA.size() != categoryIds.size()) {
            throw new EntityNotFoundException("One or more categories not found");
        }

        System.out.println(brandJPA+"goalaaaa");

        ArticleJPA articleJpa = articleEntityMapper.toEntity(article);
        articleJpa.setBrand(brandJPA);
        articleJpa.setCategories(new HashSet<>(categoriesJPA));

        ArticleJPA savedArticleJpa = articleRepository.save(articleJpa);

        savedArticleJpa = articleRepository.findById(savedArticleJpa.getId())
                .orElseThrow(() -> new EntityNotFoundException("Saved article not found"));

        Article savedArticle = articleEntityMapper.toArticle(savedArticleJpa);

        // Manually set the brand and categories to ensure proper mapping
        savedArticle.setBrand(brandEntityMapper.toBrand(savedArticleJpa.getBrand()));
        savedArticle.setCategory(savedArticleJpa.getCategories().stream()
                .map(categoryEntityMapper::toDTO)
                .collect(Collectors.toSet()));
        System.out.println(savedArticle+" Hpoalalalala");
        return savedArticle;
    }

    @Override
    public Page<Article> findAllArticles(Pageable pageable) {
        return null;
    }
}
