package com.emazon.stock.infrastructure.out.jpa.mapper;


import com.emazon.stock.domain.model.Category;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class CategoryEntityMapper {


    public abstract CategoryJPA toEntity(Category category);

    public abstract Category toDTO(CategoryJPA categoryEntity);

    public Page<Category> toCategoriesPage(Page<CategoryJPA> categoryEntities){
        List<Category> categories = categoryEntities
                .map(this::toDTO)
                .getContent();
        return new PageImpl<>(categories, PageRequest.of(categoryEntities.getNumber(), categoryEntities.getSize()), categoryEntities.getTotalElements());
    }
}
