package com.yakubozten.dto;

import java.math.BigDecimal;

public class ProductV2 {
    private  String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductV2(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public ProductV2() {
    }
}
