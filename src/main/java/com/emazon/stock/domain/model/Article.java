package com.emazon.stock.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Long id;
    private String article_id;
    private String brand_id;
    private Long price;
    private int stock;

}
