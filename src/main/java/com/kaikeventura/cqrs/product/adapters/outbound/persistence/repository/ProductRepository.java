package com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository;

import com.kaikeventura.cqrs.product.adapters.outbound.persistence.entity.ProductEntity;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.read.ProductReadOnlyRepository;
import com.kaikeventura.cqrs.product.adapters.outbound.persistence.repository.write.ProductReadWriteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class ProductRepository implements ProductReadOnlyRepository, ProductReadWriteRepository {

    private final ProductReadOnlyRepository productReadOnlyRepository;
    private final ProductReadWriteRepository productReadWriteRepository;

    public ProductRepository(ProductReadOnlyRepository productReadOnlyRepository, ProductReadWriteRepository productReadWriteRepository) {
        this.productReadOnlyRepository = productReadOnlyRepository;
        this.productReadWriteRepository = productReadWriteRepository;
    }

    @Override
    public Optional<ProductEntity> findByName(String name) {
        return productReadOnlyRepository.findByName(name);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productReadOnlyRepository.findAll();
    }

    @Override
    public List<ProductEntity> findAll(Sort sort) {
        return productReadOnlyRepository.findAll(sort);
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return productReadOnlyRepository.findAll(pageable);
    }

    @Override
    public List<ProductEntity> findAllById(Iterable<Long> longs) {
        return productReadOnlyRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return productReadOnlyRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        productReadWriteRepository.deleteById(aLong);
    }

    @Override
    public void delete(ProductEntity entity) {
        productReadWriteRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        productReadWriteRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends ProductEntity> entities) {
        productReadWriteRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productReadWriteRepository.deleteAll();
    }

    @Override
    public <S extends ProductEntity> S save(S entity) {
        return productReadWriteRepository.save(entity);
    }

    @Override
    public <S extends ProductEntity> List<S> saveAll(Iterable<S> entities) {
        return productReadWriteRepository.saveAll(entities);
    }

    @Override
    public Optional<ProductEntity> findById(Long aLong) {
        return productReadOnlyRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return productReadOnlyRepository.existsById(aLong);
    }

    @Override
    public void flush() {
        productReadWriteRepository.flush();
    }

    @Override
    public <S extends ProductEntity> S saveAndFlush(S entity) {
        return productReadWriteRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends ProductEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return productReadWriteRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<ProductEntity> entities) {
        productReadWriteRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        productReadWriteRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        productReadWriteRepository.deleteAllInBatch();
    }

    @Override
    public ProductEntity getOne(Long aLong) {
        return productReadOnlyRepository.getOne(aLong);
    }

    @Override
    public ProductEntity getById(Long aLong) {
        return productReadOnlyRepository.getById(aLong);
    }

    @Override
    public <S extends ProductEntity> Optional<S> findOne(Example<S> example) {
        return productReadOnlyRepository.findOne(example);
    }

    @Override
    public <S extends ProductEntity> List<S> findAll(Example<S> example) {
        return productReadOnlyRepository.findAll(example);
    }

    @Override
    public <S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort) {
        return productReadOnlyRepository.findAll(example, sort);
    }

    @Override
    public <S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productReadOnlyRepository.findAll(example, pageable);
    }

    @Override
    public <S extends ProductEntity> long count(Example<S> example) {
        return productReadOnlyRepository.count(example);
    }

    @Override
    public <S extends ProductEntity> boolean exists(Example<S> example) {
        return productReadOnlyRepository.exists(example);
    }

    @Override
    public <S extends ProductEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return productReadOnlyRepository.findBy(example, queryFunction);
    }
}
