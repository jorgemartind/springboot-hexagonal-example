package org.exemple.rates.domain.model;

import java.time.LocalDate;

public class RateCriteria {
    private Long brandId;
    private Long productId;
    private LocalDate date;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RateCriteria{" +
                "brandId=" + brandId +
                ", productId=" + productId +
                ", date=" + date +
                '}';
    }
}