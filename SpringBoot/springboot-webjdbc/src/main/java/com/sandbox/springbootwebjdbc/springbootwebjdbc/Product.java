package com.sandbox.springbootwebjdbc.springbootwebjdbc;

import javax.persistence.Entity;
import javax.persistence.Id;

//This will signify to Spring to treat this object as a database entity.
@Entity
public class Product {
    private Integer productId;
    private String name;
    private String productNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }
}
