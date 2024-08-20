package com.emazon.stock.application.mapper;

import com.emazon.stock.application.dto.ArticleResponse;
import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class ArticleResponseMapper {

    public abstract ArticleResponse toArticleResponse(Article article);

    public Page<ArticleResponse> toArticleResponsePage(Page<Article> articles){
        List<ArticleResponse> articleResponses = articles
                .map(this::toArticleResponse)
                .getContent();
        return new PageImpl<>(articleResponses, articles.getPageable(), articles.getTotalElements());
    }
}

