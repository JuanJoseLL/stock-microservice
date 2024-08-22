package com.emazon.stock.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Long id;
    private Category[] category;
    private Brand brand;
    private double price;
    private int stock;

}
