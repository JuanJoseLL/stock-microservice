package com.emazon.stock.infrastructure.out.jpa.repository;

import com.emazon.stock.infrastructure.out.jpa.entity.ArticleJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleRepository extends JpaRepository<ArticleJPA, Long> {
}
