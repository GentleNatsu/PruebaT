package com.mercadona.pruebat.base.application.ports.driving;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.products.ProductQuery;

import java.util.List;


public interface ProductPort {
  MercadonaPage<Product> getAll(ProductQuery query);

  Product get(Long id);

  void update(Long id, Product product);

  void patch(Long id, Product domain);

  void delete(Long id);

  void deleteList(List<Long> ids);
}
