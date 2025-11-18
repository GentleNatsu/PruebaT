package com.mercadona.pruebat.base.driving.controllers.api;

import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductQueryDto;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name="Product Api", description = "Product api")
@RequestMapping("/api/v1/products")
public interface ProductApi {

    @Operation(summary = "Get all products")
    @GetMapping
    ResponseEntity<PageResponseDto<ProductDto>> getAll(ProductQueryDto queryDto);

    @Operation(summary = "Get one product by id")
    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getById(@PathVariable Long id);

    @Operation(summary = "Update a product")
    @PutMapping("/{id}")
    ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto);
}
