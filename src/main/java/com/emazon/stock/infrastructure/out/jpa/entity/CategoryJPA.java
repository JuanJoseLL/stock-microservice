package com.emazon.stock.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Data
@EqualsAndHashCode(exclude = "articles")
@ToString(exclude = "articles")
public class CategoryJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    @Size(min = 3, max = 50, message = "Category name must be between 3 and 50 characters")
    private String name;

    @NotNull
    @Size(max = 90, message = "Category description must be less than 90 characters")
    @Column(length = 90)
    private String description;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<ArticleJPA> articles = new HashSet<>();
}
