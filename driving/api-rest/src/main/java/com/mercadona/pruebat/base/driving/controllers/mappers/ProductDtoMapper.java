package com.mercadona.pruebat.base.driving.controllers.mappers;

import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductDtoMapper {

  @Autowired
  MercadonaPageResponseBuilder mer;

  public abstract ProductDto toDto(Product product);

  public abstract Product toDomain(ProductDto productDto);

}
 