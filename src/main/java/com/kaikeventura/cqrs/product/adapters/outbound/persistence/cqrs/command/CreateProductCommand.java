package com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.command;

import java.time.LocalDateTime;

public class CreateProductCommand {

    private String name;
    private Integer price;
    private LocalDateTime createdAt;

    public CreateProductCommand() {
    }

    public CreateProductCommand(String name, Integer price, LocalDateTime createdAt) {
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
