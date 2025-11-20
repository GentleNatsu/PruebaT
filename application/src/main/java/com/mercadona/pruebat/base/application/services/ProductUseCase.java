package com.mercadona.pruebat.base.application.services;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.lib.PatchUtils;
import com.mercadona.pruebat.base.application.ports.driven.ProductDbPort;
import com.mercadona.pruebat.base.application.ports.driving.ProductPort;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.products.ProductQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductUseCase implements ProductPort {

  private final ProductDbPort dbPort;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(value = "get-products")
  public MercadonaPage<Product> getAll(ProductQuery query) {
    return dbPort.getAll(query);
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(value = "get-product-id", key = "#id")
  public Product get(Long id) {
    return dbPort.get(id).orElseThrow(() -> new PruebaTeException(ErrorCode.PROVETA_ERROR, id));
  }

  @Override
  @Transactional
  @Caching(evict = {
          @CacheEvict(cacheNames = "get-product-id",   key = "#id"),
          @CacheEvict(cacheNames = "get-products", allEntries = true)
  })
  public void update(Long id, Product product) {
    product.setId(id);
    dbPort.save(product);
  }

  @Override
  @Transactional
  @Caching(evict = {
          @CacheEvict(cacheNames = "get-product-id", key = "#id"),
          @CacheEvict(cacheNames = "get-products", allEntries = true)
  })
  public void patch(Long id, Product domain) {
    var existingProduct = dbPort.get(id).orElseThrow(() -> new PruebaTeException(ErrorCode.PROVETA_ERROR));
    PatchUtils.patchObject(existingProduct, domain);
    dbPort.save(existingProduct);
  }

  @Override
  @Transactional
  @Caching(evict = {
          @CacheEvict(cacheNames = "get-product-id", key = "#id"),
          @CacheEvict(cacheNames = "get-products", allEntries = true)
  })
  public void delete(Long id) {
    dbPort.delete(id);
  }

  @Override
  @Transactional
  @Caching(evict = {
          @CacheEvict(cacheNames = "get-product-id", allEntries = true),
          @CacheEvict(cacheNames = "get-products", allEntries = true)
  })
  public void deleteList(List<Long> ids) {
    dbPort.deleteList(ids);
  }
}
