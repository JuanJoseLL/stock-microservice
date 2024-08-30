package com.emazon.stock.application.mapper;

import com.emazon.stock.application.dto.ArticleResponse;
import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.PageModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleResponseMapper {

    public abstract ArticleResponse toArticleResponse(Article article);

    default Page<ArticleResponse> toItemResponsePage(PageModel<Article> items){
        List<ArticleResponse> itemResponses = items
                .getContent()
                .stream()
                .map(this::toArticleResponse)
                .toList();
        return new PageImpl<>(itemResponses, PageRequest.of(items.getPageNumber(), items.getPageSize()), items.getTotalElements());
    }
}

