package com.kaikeventura.cqrs.product.application.ports.inbound;

import com.kaikeventura.cqrs.product.application.domain.Product;

public interface ProductServicePort {
    Product save(Product product);
    Product update(Product product, Long id);
    Product findById(Long id);
    Product findByName(String name);
}
