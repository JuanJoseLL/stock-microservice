package com.emazon.stock.infrastructure.out.jpa.entity;


import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article")
@Data
@EqualsAndHashCode(exclude = {"brand", "categories"})
@ToString(exclude = {"brand", "categories"})
public class ArticleJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandJPA brand;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryJPA> categories = new HashSet<>();
}
