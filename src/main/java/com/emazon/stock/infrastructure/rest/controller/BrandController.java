package com.emazon.stock.infrastructure.rest.controller;

import com.emazon.stock.application.dto.BrandRequest;
import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.application.service.IBrandService;
import com.emazon.stock.domain.model.Brand;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandController {

    private final IBrandService brandService;


    @PostMapping
    public ResponseEntity<BrandResponse> saveBrand(@RequestBody BrandRequest brandRequest) {
        BrandResponse brandResponse = brandService.saveBrand(brandRequest);
        return new ResponseEntity<>(brandResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<BrandResponse>> getBrands(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "asc") String sort
    ) {
        Sort.Direction sortDirection = sort.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        Page<BrandResponse> brandResponses = brandService.findAllBrands(pageable);

        return ResponseEntity.ok(brandResponses);

    }

}

