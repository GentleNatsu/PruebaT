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
  private String customerName;
  private String customerEmail;
  private String orderDate;
  private String status;
  private Float total;
}
