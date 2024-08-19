package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandServicePort {

    Brand save(Brand brand);
    Page<Brand> findAllBrands(Pageable pageable);
}
