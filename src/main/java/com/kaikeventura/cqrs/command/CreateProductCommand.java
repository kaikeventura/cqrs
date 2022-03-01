package com.kaikeventura.cqrs.command;

public class CreateProductCommand {

    private String name;
    private Integer price;

    public CreateProductCommand() {
    }

    public CreateProductCommand(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
