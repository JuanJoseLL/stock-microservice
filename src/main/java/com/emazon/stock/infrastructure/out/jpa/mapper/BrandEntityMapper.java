package com.emazon.stock.infrastructure.out.jpa.mapper;


import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class BrandEntityMapper {

    @Mapping(target = "articles", ignore = true)
    public abstract BrandJPA toEntity(Brand brand);


    public abstract Brand toBrand(BrandJPA brandEntity);

    public Page<Brand> toBrandResponsePage(Page<BrandJPA> brands){
        List<Brand> brandResponses = brands
                .map(this::toBrand)
                .getContent();
        return new PageImpl<>(brandResponses, brands.getPageable(), brands.getTotalElements());
    }

}
