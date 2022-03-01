package com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.read;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.cqrs.annotation.ReadOnlyRepository;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@ReadOnlyRepository
public interface ProductReadOnlyRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByName(String name);
}
