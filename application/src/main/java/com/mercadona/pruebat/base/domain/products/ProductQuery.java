package com.mercadona.pruebat.base.domain.products;

import com.mercadona.pruebat.base.domain.pagination.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuery extends PageRequest {
  private String name;
  private String description;
  private Float price;
}
