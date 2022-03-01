package com.kaikeventura.cqrs.aggregator;

import com.kaikeventura.cqrs.repository.ProductRepository;
import com.kaikeventura.cqrs.command.CreateProductCommand;
import com.kaikeventura.cqrs.command.UpdateProductCommand;
import com.kaikeventura.cqrs.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class ProductAggregator {

    private final ProductRepository productRepository;

    public ProductAggregator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Product handle(CreateProductCommand cmd) {
        var product = new Product(cmd.getName(), cmd.getPrice(), LocalDateTime.now());

        return productRepository.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Product handle(UpdateProductCommand cmd) {
        var product = productRepository.findById(cmd.getPaymentId()).orElseThrow(RuntimeException::new);

        product.update(cmd.getName(), cmd.getPrice());
        return productRepository.save(product);
    }
}
