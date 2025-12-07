package com.mercadona.pruebat.base.domain.products;

import com.mercadona.pruebat.base.domain.pagination.PageRequest;

public class ProductQuery extends PageRequest {
  private String name;
  private String description;
  private Float price;

  public String toCacheKey() {
    return String.format("%d-%d-%s-%s-%s",
            getPage(),
            getPageSize(),
            name == null ? "" : name.replace("-", "_"),
            description == null ? "" : description.replace("-", "_"),
            price == null ? "" : price.toString()
    );
  }
}
