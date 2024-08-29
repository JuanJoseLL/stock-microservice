package com.emazon.stock.application.service;


import com.emazon.stock.application.dto.CategoryRequest;
import com.emazon.stock.application.dto.CategoryResponse;
import com.emazon.stock.application.mapper.CategoryRequestMapper;
import com.emazon.stock.application.mapper.CategoryResponseMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    public CategoryService(ICategoryServicePort categoryServicePort, CategoryRequestMapper categoryRequestMapper, CategoryResponseMapper categoryResponseMapper) {
        this.categoryServicePort = categoryServicePort;
        this.categoryRequestMapper = categoryRequestMapper;
        this.categoryResponseMapper = categoryResponseMapper;
    }

    @Override
    public CategoryResponse save(CategoryRequest category) {
        Category cat = categoryRequestMapper.toEntity(category);
        categoryServicePort.save(cat);
        return categoryResponseMapper.toBrandResponse(cat);
    }

    @Override
    public Page<CategoryResponse> findAllCategories(int page, int size, String sort) {
        return categoryResponseMapper.toCategryResponsePage(categoryServicePort.findAllCategories(page, size, sort));
    }
}
