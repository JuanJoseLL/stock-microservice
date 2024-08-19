package com.emazon.stock.infrastructure.out.jpa.adapter;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistancePort;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistancePort {

    private final IBrandRepository brandRepository;

    private final BrandEntityMapper brandEntityMapper;

    @Override
    public Brand save(Brand brand) {
        BrandJPA brandJpa = brandEntityMapper.toEntity(brand);

        return brandEntityMapper.toBrand(brandRepository.save(brandJpa));
    }

    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    public Page<Brand> findAllBrands(Pageable pageable) {
        return brandEntityMapper.toBrandResponsePage(brandRepository.findAll(pageable));
    }
}
