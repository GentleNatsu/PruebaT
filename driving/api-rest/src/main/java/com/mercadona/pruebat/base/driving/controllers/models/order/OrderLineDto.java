package com.mercadona.pruebat.base.driving.controllers.models.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineDto {
  private Long id;
  private Long orderId;
  private Long productId;
  private Integer quantity;
  private Float unitPrice;

  private OrderDto order;
}
 