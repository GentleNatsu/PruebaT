package com.mercadona.pruebat.base.domain.pagination;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PageRequest {

  public static final int DEFAULT_PAGE = 1;
  public static final int DEFAULT_SIZE = 25;

  @PositiveOrZero
  private Integer page;
  @Positive
  private Integer pageSize;
  private String order;

  public int getPaginaODefault() {
    return Optional.ofNullable(page).orElse(DEFAULT_PAGE);
  }

  public int getSizeODefault() {
    return Optional.ofNullable(pageSize).orElse(DEFAULT_SIZE);
  }

  public boolean isDescendent() {
    return "-".equals(this.order.substring(0, 1));
  }

  public String getAttributeForOrderBy() {
    return order.substring(1);
  }

}
