package com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.query;

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
