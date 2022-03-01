package com.kaikeventura.cqrs.command;

public class UpdateProductCommand {

    private Long PaymentId;
    private String name;
    private Integer price;

    public UpdateProductCommand() {
    }

    public UpdateProductCommand(Long paymentId, String name, Integer price) {
        PaymentId = paymentId;
        this.name = name;
        this.price = price;
    }

    public Long getPaymentId() {
        return PaymentId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
