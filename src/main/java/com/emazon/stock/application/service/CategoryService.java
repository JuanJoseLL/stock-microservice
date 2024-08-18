package com.emazon.stock.application.service;


import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.application.mapper.CategoryRequestMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;


    public CategoryService(ICategoryServicePort categoryServicePort, CategoryRequestMapper categoryRequestMapper) {
        this.categoryServicePort = categoryServicePort;
        this.categoryRequestMapper = categoryRequestMapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        Category cat = categoryRequestMapper.toEntity(category);
        categoryServicePort.save(cat);
        return category;
    }

    @Override
    public Page<Category> findAllCategories(Pageable pageable) {
        return categoryServicePort.findAllCategories(pageable);
    }
}
