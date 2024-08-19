package com.emazon.stock.application.mapper;

import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class BrandResponseMapper {

    public abstract BrandResponse toBrandResponse(Brand brandResponse);

    public Page<BrandResponse> toBrandResponsePage(Page<Brand> brands){
        List<BrandResponse> brandResponses = brands
                .map(this::toBrandResponse)
                .getContent();
        return new PageImpl<>(brandResponses, brands.getPageable(), brands.getTotalElements());
    }
}
