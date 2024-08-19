package com.emazon.stock.application.usecases;

import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistancePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistancePort brandPersistancePort;

    public BrandUseCase(IBrandPersistancePort brandPersistancePort) {
        this.brandPersistancePort = brandPersistancePort;
    }

    @Override
    public Brand save(Brand brand) {
        if (brandPersistancePort.existsByName(brand.getName())){
            throw new RuntimeException();
        }

        if (brand.getDescription().isEmpty()){
            throw new RuntimeException();

        }

        if (brand.getName().length() > 50){
            throw new RuntimeException();
        }

        if (brand.getDescription().length() > 120){
            throw new RuntimeException();
        }

        return brandPersistancePort.save(brand);
    }

    @Override
    public Page<Brand> findAllBrands(Pageable pageable) {
        return brandPersistancePort.findAllBrands(pageable);
    }
}
