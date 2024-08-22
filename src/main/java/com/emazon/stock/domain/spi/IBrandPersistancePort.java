package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.PageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandPersistancePort {

    Brand save(Brand brand);
    boolean existsByName(String name);
    PageModel<Brand> findAllBrands(int page, int size, String sort);
    Brand findBrandById(Long id);
}
