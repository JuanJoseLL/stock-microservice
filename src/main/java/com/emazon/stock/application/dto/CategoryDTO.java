package com.emazon.stock.application.dto;


import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDTO {
    @Size(max = 50, message = "The name must be less than 50 characters")
    private String name;
    private String description;
}
