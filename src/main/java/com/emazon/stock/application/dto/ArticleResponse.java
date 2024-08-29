package com.emazon.stock.application.dto;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;

import java.io.Serializable;
import java.util.Set;

public record ArticleResponse(
        double price,
        int stock,
        BrandResponse brand,
        Set<CategoryResponse> category
) implements Serializable {
}
