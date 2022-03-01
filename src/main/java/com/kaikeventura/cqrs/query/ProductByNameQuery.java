package com.kaikeventura.cqrs.query;

public class ProductByNameQuery {
    private String name;

    public ProductByNameQuery() {
    }

    public ProductByNameQuery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
