package com.rapoo.store;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Commodity {
    private Long cid;
    private String cName;
    private BigDecimal cPrice;
    private Integer count;
    public Commodity() {
    }
}
