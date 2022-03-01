package com.kaikeventura.cqrs.product.application.ports.outbound;

import com.kaikeventura.cqrs.product.application.domain.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
    Product update(Product product);
    Product findById(Long id);
    Product findByName(String name);
}
