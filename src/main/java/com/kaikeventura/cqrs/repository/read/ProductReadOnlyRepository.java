package com.kaikeventura.cqrs.repository.read;

import com.kaikeventura.cqrs.annotation.ReadOnlyRepository;
import com.kaikeventura.cqrs.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@ReadOnlyRepository
public interface ProductReadOnlyRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
