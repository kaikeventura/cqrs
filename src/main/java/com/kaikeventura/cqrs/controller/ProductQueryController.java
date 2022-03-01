package com.kaikeventura.cqrs.controller;

import com.kaikeventura.cqrs.model.Product;
import com.kaikeventura.cqrs.projection.ProductProjection;
import com.kaikeventura.cqrs.query.ProductByIdQuery;
import com.kaikeventura.cqrs.query.ProductByNameQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductQueryController {

    private final ProductProjection productProjection;

    public ProductQueryController(ProductProjection productProjection) {
        this.productProjection = productProjection;
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        var query = new ProductByIdQuery(id);
        var product = productProjection.handle(query);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("id") String name) {
        var query = new ProductByNameQuery(name);
        var product = productProjection.handle(query);

        return ResponseEntity.ok(product);
    }
}
