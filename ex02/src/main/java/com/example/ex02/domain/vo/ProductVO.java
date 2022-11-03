package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
//    상품명, 상품가격, 상품재고, 브랜드
    private String name;
    private int price;
    private int stock;
    private String brand;
}
