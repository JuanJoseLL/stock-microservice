package com.emazon.stock.infrastructure.out.jpa.mapper;

import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {BrandEntityMapper.class, CategoryEntityMapper.class})
public interface ArticleEntityMapper {

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "categories", source = "category")
    ArticleJPA toEntity(Article article);

    @Mapping(target = "category", source = "categories")
    @Mapping(target = "brand", source = "brand")
    Article toArticle(ArticleJPA articleJPA);


}