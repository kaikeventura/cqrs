package com.kaikeventura.cqrs.product.application.service;

import com.kaikeventura.cqrs.product.application.domain.Product;
import com.kaikeventura.cqrs.product.application.ports.inbound.ProductServicePort;
import com.kaikeventura.cqrs.product.application.ports.outbound.ProductRepositoryPort;

import java.time.LocalDateTime;

public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product save(Product product) {
        product.setCreatedAt(LocalDateTime.now());

        return productRepositoryPort.save(product);
    }

    @Override
    public Product update(Product product, Long id) {
        product.setUpdatedAt(LocalDateTime.now());
        product.setId(id);

        return productRepositoryPort.update(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepositoryPort.findByName(name);
    }
}
