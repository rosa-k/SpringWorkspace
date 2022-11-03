package com.example.product.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long productNumber;
    private String productName;
    private int productPrice;
    private int productStock;
    private String productBrand;
    private String productRegisterDate;
    private String productUpdateDate;
}