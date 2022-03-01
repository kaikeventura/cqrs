package com.kaikeventura.cqrs.product.application.domain;

import java.time.LocalDateTime;

public class Product {

    private Long id;

    private String name;

    private Integer price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, Integer price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void update(String newName, Integer newPrice) {
        this.name = newName;
        this.price = newPrice;
        this.updatedAt = LocalDateTime.now();
    }
}
