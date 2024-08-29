package com.emazon.stock.application.service;

import com.emazon.stock.application.dto.*;
import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    CategoryResponse save(CategoryRequest category);

    Page<CategoryResponse> findAllCategories(int page, int size, String sort);
}
