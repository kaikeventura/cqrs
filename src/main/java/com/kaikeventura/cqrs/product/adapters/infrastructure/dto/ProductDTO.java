package com.kaikeventura.cqrs.product.adapters.infrastructure.dto;

public class ProductDTO {
    private Long id;

    private String name;

    private Integer price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
