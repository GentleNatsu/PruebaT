package com.mercadona.pruebat.base.domain.products;

import com.mercadona.pruebat.base.domain.SectionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private Float price;
  private SectionType sectionType;

}
