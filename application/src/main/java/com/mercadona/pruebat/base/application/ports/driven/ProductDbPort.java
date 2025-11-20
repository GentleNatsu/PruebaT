package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.products.ProductQuery;

import java.util.List;
import java.util.Optional;

public interface ProductDbPort {
  MercadonaPage<Product> getAll(ProductQuery query);

  Optional<Product> get(Long id);

  void save(Product product);

  void delete(Long id);

  void deleteList(List<Long> ids);
}
