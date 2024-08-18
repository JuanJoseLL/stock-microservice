package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    CategoryDTO save(CategoryDTO category);

    Page<Category> findAllCategories(Pageable pageable);
}
