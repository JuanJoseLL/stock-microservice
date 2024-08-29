package com.emazon.stock.infrastructure.out.jpa.adapter;

import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.model.PageModel;
import com.emazon.stock.domain.spi.ICategoryPersistancePort;
import com.emazon.stock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.mapper.PageAdapterMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistancePort {


    private final ICategoryRepository categoryRepository;

    private final CategoryEntityMapper categoryEntityMapper;
    private final PageAdapterMapper pageAdapterMapper;


    @Override
    public void save(Category category) {

            categoryRepository.save(categoryEntityMapper.toEntity(category));

    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public PageModel<Category> findAllCategories(int page, int size, String sort) {
        Sort.Direction sortDirection = sort.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        return pageAdapterMapper.toPageModel(categoryEntityMapper.toCategoriesPage(categoryRepository.findAll(pageable)));
    }
}
