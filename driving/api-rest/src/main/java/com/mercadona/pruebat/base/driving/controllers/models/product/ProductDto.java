package com.mercadona.pruebat.base.driving.controllers.models.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

  @NotNull
  private Long productId;
  private String productDescription;
  private Integer quantity;
  @NotNull
  private Float price;


}
 