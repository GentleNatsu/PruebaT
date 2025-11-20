package com.mercadona.pruebat.base.driving.controllers.models.product;

import com.mercadona.pruebat.base.driving.controllers.models.order.OrderLineDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
public class ProductDto {

  @NotNull
  private Long id;
  private String name;
  private String description;
  @NotNull
  private Float price;
  @NotNull
  @PositiveOrZero
  private Integer stock;
  private OffsetDateTime createdAt;

  private Set<OrderLineDto> orderLines;
}
 