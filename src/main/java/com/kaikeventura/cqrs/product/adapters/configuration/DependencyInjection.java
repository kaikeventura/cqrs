package com.kaikeventura.cqrs.product.adapters.configuration;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.MySQLProductPersistence;
import com.kaikeventura.cqrs.product.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    public ProductService productService(MySQLProductPersistence mySQLProductPersistence) {
        return new ProductService(mySQLProductPersistence);
    }
}
