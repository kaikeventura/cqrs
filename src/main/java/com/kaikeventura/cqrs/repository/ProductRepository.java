package com.kaikeventura.cqrs.repository;

import com.kaikeventura.cqrs.model.Product;
import com.kaikeventura.cqrs.repository.read.ProductReadOnlyRepository;
import com.kaikeventura.cqrs.repository.write.ProductReadWriteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
    public Optional<Product> findByName(String name) {
        return productReadOnlyRepository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productReadOnlyRepository.findAll();
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return productReadOnlyRepository.findAll(sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productReadOnlyRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAllById(Iterable<Long> longs) {
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
    public void delete(Product entity) {
        productReadWriteRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        productReadWriteRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        productReadWriteRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productReadWriteRepository.deleteAll();
    }

    @Override
    public <S extends Product> S save(S entity) {
        return productReadWriteRepository.save(entity);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return productReadWriteRepository.saveAll(entities);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
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
    public <S extends Product> S saveAndFlush(S entity) {
        return productReadWriteRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return productReadWriteRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {
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
    public Product getOne(Long aLong) {
        return productReadOnlyRepository.getOne(aLong);
    }

    @Override
    public Product getById(Long aLong) {
        return productReadOnlyRepository.getById(aLong);
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return productReadOnlyRepository.findOne(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return productReadOnlyRepository.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return productReadOnlyRepository.findAll(example, sort);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productReadOnlyRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return productReadOnlyRepository.count(example);
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return productReadOnlyRepository.exists(example);
    }

    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return productReadOnlyRepository.findBy(example, queryFunction);
    }
}
