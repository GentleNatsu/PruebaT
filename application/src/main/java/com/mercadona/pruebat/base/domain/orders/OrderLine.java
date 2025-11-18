package com.mercadona.pruebat.base.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
  private Long id;
  private Long orderId;
  private Long productId;
  private Integer quantity;
  private BigDecimal unitPrice;

  private Order order;
}
