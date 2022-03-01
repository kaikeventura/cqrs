package com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.projection;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity.ProductEntity;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.query.ProductByIdQuery;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.query.ProductByNameQuery;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductEntity handle(ProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    public ProductEntity handle(ProductByNameQuery query) {
        return productRepository.findByName(query.getName()).orElseThrow(RuntimeException::new);
    }
}
