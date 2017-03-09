package com.sandbox;

import java.math.BigDecimal;

/**
 * Created by ravikir on 3/1/2017.
 */
public class SandboxItem {

    double proratedDiscount;

    public double getProratedDiscount() {
        return proratedDiscount;
    }

    public void setProratedDiscount(double proratedDiscount) {
        this.proratedDiscount = proratedDiscount;
    }

    boolean prorationEligible;

    public boolean isProrationEligible() {
        return prorationEligible;
    }

    public void setProrationEligible(boolean prorationEligible) {
        this.prorationEligible = prorationEligible;
    }

    String promoGroupCode;

    public String getPromoGroupCode() {
        return promoGroupCode;
    }

    public void setPromoGroupCode(String promoGroupCode) {
        this.promoGroupCode = promoGroupCode;
    }

    double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    int quantity;

    int prorateQualifiedQuantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProrateQualifiedQuantity() {
        return prorateQualifiedQuantity;
    }

    public void setProrateQualifiedQuantity(int prorateQualifiedQuantity) {
        this.prorateQualifiedQuantity = prorateQualifiedQuantity;
    }

    public SandboxItem() {
    }

}
