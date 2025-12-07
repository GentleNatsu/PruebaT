package com.mercadona.pruebat.base.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  private Long id;
  private String customerId;
  private String storeId;
  private String address;
  private Integer priority;
}
