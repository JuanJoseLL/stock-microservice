package com.emazon.stock.domain.usecases;

import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistancePort categoryPersistancePort;

    public CategoryUseCase(ICategoryPersistancePort categoryPersistancePort) {
        this.categoryPersistancePort = categoryPersistancePort;
    }

    @Override
    public void save(Category category) {
        categoryPersistancePort.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }
}
