package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryServicePort {

    void save(Category category);

    Page<Category> findAllCategories(Pageable pageable);

}
