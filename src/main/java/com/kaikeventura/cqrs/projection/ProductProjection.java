package com.kaikeventura.cqrs.projection;

import com.kaikeventura.cqrs.model.Product;
import com.kaikeventura.cqrs.query.ProductByIdQuery;
import com.kaikeventura.cqrs.query.ProductByNameQuery;
import com.kaikeventura.cqrs.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Product handle(ProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    public Product handle(ProductByNameQuery query) {
        return productRepository.findByName(query.getName()).orElseThrow(RuntimeException::new);
    }
}
