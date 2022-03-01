package com.kaikeventura.cqrs.product.adapters.inbound.controller;

import com.kaikeventura.cqrs.product.adapters.infrastructure.dto.ProductDTO;
import com.kaikeventura.cqrs.product.application.domain.Product;
import com.kaikeventura.cqrs.product.application.ports.inbound.ProductServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        var product = productServicePort.save(new Product(productDTO.getName(), productDTO.getPrice()));

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        var product = productServicePort.update(new Product(productDTO.getName(), productDTO.getPrice()), id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        var product = productServicePort.findById(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        var product = productServicePort.findByName(name);

        return ResponseEntity.ok(product);
    }
}
