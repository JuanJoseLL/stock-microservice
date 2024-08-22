package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.PageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandServicePort {

    Brand save(Brand brand);
    PageModel<Brand> findAllBrands(int page, int size, String sort);
}
