package com.emazon.stock.application.dto;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;

import java.io.Serializable;
import java.util.Set;

public record ArticleRequest(
        double price,
        int stock,
        Brand brand,
        Set<Category> category
) implements Serializable {
}
