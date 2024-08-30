package com.emazon.stock.infrastructure.out.jpa.mapper;

import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public interface ArticleEntityMapper {


    ArticleJPA toEntity(Article article);


    Article toArticle(ArticleJPA articleJPA);

    Page<Article> toItemsPage(Page<ArticleJPA> itemEntities);

}