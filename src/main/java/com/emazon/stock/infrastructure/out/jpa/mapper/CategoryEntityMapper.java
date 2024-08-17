package com.emazon.stock.infrastructure.out.jpa.mapper;


import com.emazon.stock.domain.model.Category;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {

    CategoryJPA toEntity(Category category);
    Category toDTO(CategoryJPA categoryEntity);
}
