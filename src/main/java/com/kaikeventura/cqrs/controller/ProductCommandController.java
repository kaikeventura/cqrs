package com.kaikeventura.cqrs.controller;

import com.kaikeventura.cqrs.command.UpdateProductCommand;
import com.kaikeventura.cqrs.dto.ProductDTO;
import com.kaikeventura.cqrs.aggregator.ProductAggregator;
import com.kaikeventura.cqrs.command.CreateProductCommand;
import com.kaikeventura.cqrs.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductCommandController {

    private final ProductAggregator productAggregator;

    public ProductCommandController(ProductAggregator productAggregator) {
        this.productAggregator = productAggregator;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO) {
        var command = new CreateProductCommand(productDTO.getName(), productDTO.getPrice());
        var product = productAggregator.handle(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody ProductDTO productDTO) {
        var command = new UpdateProductCommand(productDTO.getId(), productDTO.getName(), productDTO.getPrice());
        var product = productAggregator.handle(command);

        return ResponseEntity.ok(product);
    }
}
