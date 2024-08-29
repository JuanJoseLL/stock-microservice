package com.emazon.stock.infrastructure.out.jpa.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
@Data
@EqualsAndHashCode(exclude = "articles")
@ToString(exclude = "articles")
public class BrandJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    private String name;

    @Column(length = 120)
    @NotNull
    private String description;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<ArticleJPA> articles = new HashSet<>();
}