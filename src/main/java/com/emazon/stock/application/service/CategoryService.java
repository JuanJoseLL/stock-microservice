package com.emazon.stock.application.service;


import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.application.mapper.CategoryRequestMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final ICategoryServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;


    public CategoryService(ICategoryServicePort categoryServicePort, CategoryRequestMapper categoryRequestMapper) {
        this.categoryServicePort = categoryServicePort;
        this.categoryRequestMapper = categoryRequestMapper;
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        System.out.printf("CategoryService.save %s\n", category.getName());
        Category cat = categoryRequestMapper.toEntity(category);
        System.out.printf("mapper");
        categoryServicePort.save(cat);
        System.out.println("CategoryService.save");
        return category;
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
