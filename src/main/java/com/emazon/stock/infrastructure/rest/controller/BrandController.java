package com.emazon.stock.infrastructure.rest.controller;

import com.emazon.stock.application.dto.BrandRequest;
import com.emazon.stock.application.dto.BrandResponse;
import com.emazon.stock.application.service.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

