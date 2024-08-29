package com.emazon.stock.infrastructure.rest.controller;

import com.emazon.stock.application.dto.CategoryRequest;
import com.emazon.stock.application.dto.CategoryResponse;
import com.emazon.stock.application.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;


    @Operation(summary = "Get all category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categories have been successfully obtained", content = @Content),
            @ApiResponse(responseCode = "500", description = "Server internal error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getCategory(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "asc") String sort
    ) {

        Page<CategoryResponse> categoryResponses = categoryService.findAllCategories(page, size, sort);

        return ResponseEntity.ok(categoryResponses);

    }

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Category name or description too long", content = @Content),
            @ApiResponse(responseCode = "400", description = "Category already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory( @RequestBody CategoryRequest category) {
        categoryService.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
