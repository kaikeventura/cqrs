package com.kaikeventura.cqrs.repository.write;

import com.kaikeventura.cqrs.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReadWriteRepository extends JpaRepository<Product, Long> {
}
