package com.kaikeventura.cqrs.product.adapters.infrastructure.converter;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity.ProductEntity;
import com.kaikeventura.cqrs.product.application.domain.Product;

public class ProductConverter {

    private ProductConverter(){

    }

    public static ProductEntity toProductEntity(Product product) {
        return new ProductEntity(
                product.getName(),
                product.getPrice(),
                product.getCreatedAt()
        );
    }

    public static Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getCreatedAt(),
                productEntity.getUpdatedAt()
        );
    }
}
