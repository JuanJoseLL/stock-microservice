package com.emazon.stock.application.port;

import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryRepository {
    Category save(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    void deleteCategory(Long id);
}
