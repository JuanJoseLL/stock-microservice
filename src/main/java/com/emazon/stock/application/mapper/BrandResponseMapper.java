package com.emazon.stock.application.mapper;

import com.emazon.stock.application.dto.BrandResponse;
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
public abstract class BrandResponseMapper {

    public abstract BrandResponse toBrandResponse(Brand brandResponse);

    public Page<BrandResponse> toBrandResponsePage(PageModel<Brand> brands){
        List<BrandResponse> brandResponses = brands
                .getContent()
                .stream()
                .map(this::toBrandResponse)
                .toList();
        return new PageImpl<>(brandResponses, PageRequest.of(brands.getPageNumber(), brands.getPageSize()), brands.getTotalElements());
    }
}
