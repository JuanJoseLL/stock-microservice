package com.emazon.stock.infrastructure.out.jpa.mapper;


import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class BrandEntityMapper {

    public abstract BrandJPA toEntity(Brand brand);

    public abstract Brand toBrand(BrandJPA brandEntity);


}
