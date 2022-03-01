package com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.aggregator;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.ProductRepository;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.command.CreateProductCommand;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.command.UpdateProductCommand;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductAggregator {

    private final ProductRepository productRepository;

    public ProductAggregator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ProductEntity handle(CreateProductCommand cmd) {
        var product = new ProductEntity(cmd.getName(), cmd.getPrice(), cmd.getCreatedAt());

        return productRepository.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ProductEntity handle(UpdateProductCommand cmd) {
        var product = productRepository.findById(cmd.getPaymentId()).orElseThrow(RuntimeException::new);

        product.update(cmd.getName(), cmd.getPrice(), cmd.getUpdatedAt());
        return productRepository.save(product);
    }
}
