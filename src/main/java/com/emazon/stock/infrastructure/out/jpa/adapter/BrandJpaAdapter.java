package com.emazon.stock.infrastructure.out.jpa.adapter;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.PageModel;
import com.emazon.stock.domain.spi.IBrandPersistancePort;
import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.emazon.stock.infrastructure.out.jpa.mapper.PageAdapterMapper;
import com.emazon.stock.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistancePort {

    private final IBrandRepository brandRepository;

    private final BrandEntityMapper brandEntityMapper;

    private final PageAdapterMapper pageAdapterMapper;

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
    public PageModel<Brand> findAllBrands(int page, int size, String sort) {
        Sort.Direction sortDirection = sort.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));
        return pageAdapterMapper.toPageModel(brandEntityMapper.toBrandResponsePage(brandRepository.findAll(pageable)));
    }

    @Override
    public Brand findBrandById(Long id) {
        return null;
    }
}
