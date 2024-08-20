package com.emazon.stock.application.dto;

import java.io.Serializable;

public record ArticleRequest(
        double price,
        int stock,
        String brand_id,
        String[] category_id
) implements Serializable {
}
