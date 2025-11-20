package com.mercadona.pruebat.base.driving.controllers.adapters.products;

import com.mercadona.pruebat.base.application.ports.driving.ProductPort;
import com.mercadona.pruebat.base.driving.controllers.api.ProductApi;
import com.mercadona.pruebat.base.driving.controllers.mappers.ProductDtoMapper;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

  private final ProductPort port;
  private final ProductDtoMapper mapper;

  @Override
  public ResponseEntity<PageResponseDto<ProductDto>> getAll(ProductQueryDto queryDto) {
    var query = mapper.toDomain(queryDto);
    var page = port.getAll(query);
    return ResponseEntity.ok(mapper.toDto(page));
  }

  @Override
  public ResponseEntity<ProductDto> getById(Long id) {
    var product = port.get(id);
    return ResponseEntity.ok(mapper.toDto(product));
  }

  @Override
  public ResponseEntity<Void> updateProduct(Long id, @Validated ProductDto productDto) {
    port.update(id, mapper.toDomain(productDto));
    return ResponseEntity.noContent().build();
  }
}
