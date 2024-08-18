package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryServicePort {

    void save(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long categoryId);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();

    Page<Category> findAllCategories(Pageable pageable);

}
