package com.mercadona.pruebat.base.driving.controllers.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.products.ProductQuery;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductQueryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductDtoMapper {

  @Autowired
  MercadonaPageResponseBuilder mer;

  public abstract ProductDto toDto(Product product);

  public abstract Product toDomain(ProductDto productDto);

  public abstract ProductQuery toDomain(ProductQueryDto queryDto);

  @Mapping(source = ".", target = "pagination")
  @Mapping(source = "content", target = "data")
  public abstract PageResponseDto<ProductDto> toDto(MercadonaPage<Product> page);

  public Pagination toPagination(MercadonaPage<Product> page) {

    return mer.builder().requestedPage(page.getNumber())
            .requestedSize(page.getSize())
            .retrievedResults(page.getNumberOfElements())
            .totalResults(page.getTotalElements())
            .buildNextPage(page.getNumber(), page.getSize(), page.getTotalPages())
            .buildPreviousPage(page.getNumber(), page.getSize())
            .build();

  }
}
 