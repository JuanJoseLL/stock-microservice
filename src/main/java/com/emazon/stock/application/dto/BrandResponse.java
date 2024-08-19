package com.emazon.stock.application.dto;

import java.io.Serializable;

public record BrandResponse(
        String name,
        String description
) implements Serializable {
}
