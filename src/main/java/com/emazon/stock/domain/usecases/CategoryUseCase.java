package com.emazon.stock.domain.usecases;

import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.PageModel;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;
import com.emazon.stock.infrastructure.exception.CategoryAlreadyExistException;
import com.emazon.stock.infrastructure.exception.CategoryDescriptionMissingException;
import com.emazon.stock.infrastructure.exception.CategoryDescriptionTooLongException;
import com.emazon.stock.infrastructure.exception.CategoryNameTooLongException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistancePort categoryPersistancePort;

    public CategoryUseCase(ICategoryPersistancePort categoryPersistancePort) {
        this.categoryPersistancePort = categoryPersistancePort;
    }

    @Override
    public void save(Category category) {
        if (categoryPersistancePort.existsByName(category.getName())){
            throw new CategoryAlreadyExistException();
        }

        if(category.getDescription().length() > 90){
            throw new CategoryDescriptionTooLongException();
        }

        if(category.getName().length() > 50){
            throw new CategoryNameTooLongException();
        }

        if(category.getDescription().isEmpty()){
            throw new CategoryDescriptionMissingException();
        }
        categoryPersistancePort.save(category);
    }

    @Override
    public PageModel<Category> findAllCategories(int size, int page, String sort) {
        return categoryPersistancePort.findAllCategories(page, size, sort);
    }
}
