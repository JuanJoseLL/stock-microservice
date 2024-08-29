package com.emazon.stock.application.mapper;

import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.application.dto.CategoryRequest;
import com.emazon.stock.application.dto.CategoryResponse;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
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
public abstract class CategoryResponseMapper {


    public abstract CategoryResponse toBrandResponse(Category category);

    public Page<CategoryResponse> toCategryResponsePage(PageModel<Category> categories){
        List<CategoryResponse> categoryResponses = categories
                .getContent()
                .stream()
                .map(this::toBrandResponse)
                .toList();
        return new PageImpl<>(categoryResponses, PageRequest.of(categories.getPageNumber(), categories.getPageSize()), categories.getTotalElements());
    }
}
