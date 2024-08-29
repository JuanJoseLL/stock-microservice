package com.emazon.stock.application.mapper;



import com.emazon.stock.application.dto.CategoryRequest;

import com.emazon.stock.domain.model.Category;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public  interface CategoryRequestMapper {
    Category toEntity(CategoryRequest category);

}
