package com.emazon.stock.infrastructure.out.jpa.mapper;

import com.emazon.stock.domain.model.Article;
import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class ArticleEntityMapper {

    public abstract ArticleJPA toEntity(Article article);

    public abstract Article toArticle(ArticleJPA articleEntity);



}
