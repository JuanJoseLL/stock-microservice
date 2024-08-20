package com.emazon.stock.application.mapper;


import com.emazon.stock.application.dto.ArticleRequest;
import com.emazon.stock.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleRequestMapper {
    Article toArticle(ArticleRequest article);
}
