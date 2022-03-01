package com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.write;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReadWriteRepository extends JpaRepository<ProductEntity, Long> {
}
