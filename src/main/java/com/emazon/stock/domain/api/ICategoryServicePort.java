package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    void save(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long categoryId);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();

}
