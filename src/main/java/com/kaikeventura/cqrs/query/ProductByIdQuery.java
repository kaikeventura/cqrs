package com.kaikeventura.cqrs.query;

public class ProductByIdQuery {
    private Long id;

    public ProductByIdQuery() {
    }

    public ProductByIdQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
