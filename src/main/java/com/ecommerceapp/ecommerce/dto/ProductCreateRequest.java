package com.ecommerceapp.ecommerce.dto;

public class ProductCreateRequest {
    private String name;
    private Double price;
    private Long categoryId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
}
