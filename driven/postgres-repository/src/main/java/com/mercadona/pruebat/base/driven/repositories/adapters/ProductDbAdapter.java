package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.framework.cna.commons.domain.MercadonaCursor;
import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.lib.repository.builders.MercadonaPageBuilder;
import com.mercadona.pruebat.base.application.ports.driven.ProductDbPort;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.products.ProductQuery;
import com.mercadona.pruebat.base.driven.repositories.ProductRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.ProductDbMapper;
import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import com.mercadona.pruebat.base.driven.repositories.specifications.ProductSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductDbAdapter implements ProductDbPort {

  private final MercadonaPageBuilder mercadonaPageBuilder;

  private final ProductRepository repository;
  private final ProductDbMapper mapper;

  @Override
  public MercadonaPage<Product> getAll(ProductQuery query) {
    var pageRequest =  mercadonaPageBuilder.builder().page(query.getPage()).pageSize(query.getPageSize()).sort(query.getOrder()).build();
    var spec = new ProductSpecification(query);
    var pageMOs = repository.findAll(spec, pageRequest);
    var filteredIds = pageMOs.getContent().stream().map(ProductMO::getId).toList();
    var productMOs = repository.findAllByIdInWithOrderLinesAndOrders(filteredIds);
    var productsOrdered = getProductsOrdered(productMOs, filteredIds);
    var page = new PageImpl<>(productsOrdered, pageRequest, pageMOs.getTotalElements());
    return MercadonaPage.of(page);
  }

  private List<Product> getProductsOrdered(Collection<ProductMO> productMOs, List<Long> filteredIds) {
    Map<Long, ProductMO> productById = productMOs.stream().collect(Collectors.toMap(ProductMO::getId, Function.identity()));
    return filteredIds.stream()
      .map(productById::get)
      .filter(Objects::nonNull)
      .map(mapper::toDomain)
      .collect(Collectors.toList());
  }


  @Override
  public Optional<Product> get(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  public void save(Product product) {
    repository.save(mapper.toDb(product));
  }

}
