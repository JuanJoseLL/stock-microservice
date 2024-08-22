package com.emazon.stock.application.dto;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;

import java.io.Serializable;

public record ArticleResponse(
        double price,
        int stock,
        Brand brand,
        Category[] category
) implements Serializable {
}
