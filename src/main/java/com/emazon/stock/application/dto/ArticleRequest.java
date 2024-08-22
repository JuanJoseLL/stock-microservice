package com.emazon.stock.application.dto;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;

import java.io.Serializable;

public record ArticleRequest(
        double price,
        int stock,
        Long brand,
        Long[] category
) implements Serializable {
}
