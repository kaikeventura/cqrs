package com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.command;

import java.time.LocalDateTime;

public class UpdateProductCommand {

    private Long paymentId;
    private String name;
    private Integer price;
    private LocalDateTime updatedAt;

    public UpdateProductCommand() {
    }

    public UpdateProductCommand(Long paymentId, String name, Integer price, LocalDateTime updatedAt) {
        this.paymentId = paymentId;
        this.name = name;
        this.price = price;
        this.updatedAt = updatedAt;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
