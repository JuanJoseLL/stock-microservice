package com.emazon.stock.infrastructure.out.jpa.adapter;

import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;
import com.emazon.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistancePort {


    private final ICategoryRepository categoryRepository;

    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(Category category) {

            categoryRepository.save(categoryEntityMapper.toEntity(category));

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

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public Page<Category> findAllCategories(Pageable pageable) {
        return categoryEntityMapper.toCategoriesPage(categoryRepository.findAll(pageable));
    }
}
