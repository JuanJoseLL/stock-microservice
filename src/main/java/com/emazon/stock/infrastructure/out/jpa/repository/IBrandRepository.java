package com.emazon.stock.infrastructure.out.jpa.repository;

import com.emazon.stock.infrastructure.out.jpa.entity.BrandJPA;
import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandJPA, Long> {


    Page<BrandJPA> findAll(Pageable pageable);
    boolean existsByName(String name);
    Optional<BrandJPA> findByName(String name);
    void deleteById(Long categoryId);
}
