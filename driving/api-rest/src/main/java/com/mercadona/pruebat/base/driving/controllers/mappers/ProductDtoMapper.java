package com.mercadona.pruebat.base.driving.controllers.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.products.ProductQuery;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductQueryDto;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PaginationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

  ProductDto toDto(Product product);
  Product toDomain(ProductDto productDto);

  ProductQuery toDomain(ProductQueryDto queryDto);

  @Mapping(source = ".", target = "pagination")
  @Mapping(source = "content", target = "data")
  PageResponseDto<ProductDto> toDto(MercadonaPage<Product> page);

  default PaginationDto toPagination(MercadonaPage<Product> page) {
    PaginationDto pagination = new PaginationDto();
    pagination.setPreviousPage(getPreviousPage(page));
    pagination.setRequestedPage(getRequestedPage(page));
    pagination.setRequestedSize(getRequestedSize(page));
    pagination.setRetrievedResults(getRetrievedResults(page));
    pagination.setTotalResults(getTotalResults(page));
    pagination.setNextPage(getNextPage(page));
    pagination.setTotalPages(getTotalPages(page));
    return pagination;
  }

  @Named("getPreviousPage")
  default String getPreviousPage(MercadonaPage<Product> page) {
    //return String.valueOf(page.previousOrFirstPageable().previousOrFirst().getPageNumber());
    return null;
  }

  @Named("getRequestedPage")
  default Integer getRequestedPage(MercadonaPage<Product> page) {
    return page.getNumber() + 1;
  }

  @Named("getRequestedSize")
  default Integer getRequestedSize(MercadonaPage<Product> page) {
    return page.getSize();
  }

  @Named("getRetrievedResults")
  default Integer getRetrievedResults(MercadonaPage<Product> page) {
    return page.getNumberOfElements();
  }

  @Named("getTotalResults")
  default Long getTotalResults(MercadonaPage<Product> page) {
    return page.getTotalElements();
  }

  @Named("getNextPage")
  default String getNextPage(MercadonaPage<Product> page) {
    //return String.valueOf(page.nextOrLastPageable().next().getPageNumber());
    return null;
  }

  @Named("getTotalPages")
  default Integer getTotalPages(MercadonaPage<Product> page) {
    return page.getTotalPages();
  }

  @Named("booleanToString")
  default String booleanToString(Boolean boo) {
    return Optional.ofNullable(boo).map(b -> b ? "S" : "N").orElse(null);
  }
}
 