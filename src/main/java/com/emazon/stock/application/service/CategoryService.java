package com.emazon.stock.application.service;


import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.domain.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{


    @Override
    public CategoryDTO save(CategoryDTO category) {
        System.out.println("CategoryService.save");
        return null;
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
