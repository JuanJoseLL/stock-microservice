package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.BrandRequest;
import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.application.mapper.BrandRequestMapper;
import com.emazon.stock.application.mapper.BrandResponseMapper;
import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BrandService implements IBrandService {

    private final IBrandServicePort brandServicePort;
    private final BrandRequestMapper brandRequestMapper;
    private final BrandResponseMapper brandResponseMapper;

    public BrandService(IBrandServicePort brandServicePort, BrandRequestMapper brandRequestMapper, BrandResponseMapper brandResponseMapper) {
        this.brandServicePort = brandServicePort;
        this.brandRequestMapper = brandRequestMapper;
        this.brandResponseMapper = brandResponseMapper;
    }


    @Override
    public BrandResponse saveBrand(BrandRequest brandRequest) {
        Brand brand = brandRequestMapper.toCategory(brandRequest);
        brandServicePort.save(brand);
        return brandResponseMapper.toBrandResponse(brand);
    }

    @Override
    public Page<BrandResponse> findAllBrands(Pageable pageable) {
        return brandResponseMapper.toBrandResponsePage(brandServicePort.findAllBrands(pageable));
    }
}
