package com.mercadona.pruebat.base.driving.controllers.models.product;

import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductQueryDto extends PageRequestDto {
  private String name;
  private String description;
  private Float price;
}