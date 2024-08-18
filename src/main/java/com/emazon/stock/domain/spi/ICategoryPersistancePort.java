package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryPersistancePort {

    void save(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long categoryId);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    boolean existsByName(String name);

    Page<Category> findAllCategories(Pageable pageable);
}
