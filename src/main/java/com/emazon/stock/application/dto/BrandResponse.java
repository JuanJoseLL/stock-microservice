package com.emazon.stock.application.dto;

import java.io.Serializable;

public record BrandResponse(
        Long id,
        String name,
        String description
) implements Serializable {
}
