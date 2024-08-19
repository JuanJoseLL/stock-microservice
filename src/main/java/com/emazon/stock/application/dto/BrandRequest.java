package com.emazon.stock.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record BrandRequest(
        @Size(max = 50)
        String name,
        @Size(max = 120)
        @NotNull
        String description
) implements Serializable {
}
