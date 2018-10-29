package com.rapoo.store;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String productName;
    private String supplier;
    private String brand;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private Double cutoff;
    private Long dir_id;
}
