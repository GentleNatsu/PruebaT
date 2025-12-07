package com.mercadona.pruebat.base.domain.products;

import com.mercadona.pruebat.base.domain.orders.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private Float price;
  private OffsetDateTime createdAt;

  private Set<OrderLine> orderLines;
}
