package com.emazon.stock.infrastructure.rest.controller;

import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.application.service.ICategoryService;
import com.emazon.stock.domain.model.Category;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping
    public void getCategory() {
        System.out.println("CategoryController.createCategory");

    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory( @RequestBody CategoryDTO category) {
        categoryService.save(category);
        System.out.println("CategoryController.createCategory");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
