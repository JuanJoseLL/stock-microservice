package com.emazon.stock.infrastructure.rest.controller;

import com.emazon.stock.application.dto.CategoryDTO;
import com.emazon.stock.application.service.ICategoryService;
import com.emazon.stock.domain.model.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<Category>> getCategory(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "asc") String sort
    ) {
        Sort.Direction sortDirection = sort.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        Page<Category> categoryResponses = categoryService.findAllCategories(pageable);
        System.out.println("CategoryController.getCategory");
        return ResponseEntity.ok(categoryResponses);

    }

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Category name or description too long", content = @Content),
            @ApiResponse(responseCode = "400", description = "Category already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory( @RequestBody CategoryDTO category) {
        categoryService.save(category);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
