package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandPersistancePort {

    Brand save(Brand brand);
    boolean existsByName(String name);
    Page<Brand> findAllBrands(Pageable pageable);
}
