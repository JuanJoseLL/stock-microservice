package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryService {

    CategoryDTO save(CategoryDTO category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    void deleteCategory(Long id);

}
