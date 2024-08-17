package com.emazon.stock.infrastructure.out.jpa.repository;

import com.emazon.stock.infrastructure.out.jpa.entity.CategoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryJPA, Long>{


    Optional<CategoryJPA> findById(Long categoryName);

    void deleteById(Long categoryId);
}
