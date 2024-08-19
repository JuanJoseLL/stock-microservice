package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.BrandRequest;
import com.emazon.stock.application.dto.BrandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandService {

    BrandResponse saveBrand(BrandRequest brand);
    Page<BrandResponse> findAllBrands(Pageable pageable);
}
