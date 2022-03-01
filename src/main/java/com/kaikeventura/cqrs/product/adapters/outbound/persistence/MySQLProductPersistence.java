package com.kaikeventura.cqrs.product.adapters.outbound.persistence;

import com.kaikeventura.cqrs.product.adapters.infrastructure.converter.ProductConverter;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.aggregator.ProductAggregator;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.command.CreateProductCommand;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.command.UpdateProductCommand;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.projection.ProductProjection;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.query.ProductByIdQuery;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.query.ProductByNameQuery;
import com.kaikeventura.cqrs.product.application.domain.Product;
import com.kaikeventura.cqrs.product.application.ports.outbound.ProductRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class MySQLProductPersistence implements ProductRepositoryPort {

    private final ProductAggregator aggregator;
    private final ProductProjection projection;

    public MySQLProductPersistence(ProductAggregator aggregator, ProductProjection projection) {
        this.aggregator = aggregator;
        this.projection = projection;
    }

    @Override
    public Product save(Product product) {
        var command = new CreateProductCommand(product.getName(), product.getPrice(), product.getCreatedAt());
        var productEntity = aggregator.handle(command);

        return ProductConverter.toProduct(productEntity);
    }

    @Override
    public Product update(Product product) {
        var command = new UpdateProductCommand(product.getId(), product.getName(), product.getPrice(), product.getUpdatedAt());
        var productEntity = aggregator.handle(command);

        return ProductConverter.toProduct(productEntity);
    }

    @Override
    public Product findById(Long id) {
        var query = new ProductByIdQuery(id);
        var productEntity = projection.handle(query);

        return ProductConverter.toProduct(productEntity);
    }

    @Override
    public Product findByName(String name) {
        var query = new ProductByNameQuery(name);
        var productEntity = projection.handle(query);

        return ProductConverter.toProduct(productEntity);
    }
}
