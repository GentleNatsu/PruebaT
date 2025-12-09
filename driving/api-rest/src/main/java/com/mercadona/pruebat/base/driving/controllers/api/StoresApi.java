package com.mercadona.pruebat.base.driving.controllers.api;

import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoWithProducts;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreQueryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name="Stores Api", description = "Stores api")
@RequestMapping("/api/v1/stores")
public interface StoresApi {

    @Operation(summary = "Get all stores")
    @GetMapping
    ResponseEntity<PageResponseDto<StoreDtoWithProducts>> getAll(StoreQueryDto queryDto);

    @Operation(summary = "Get one store by id")
    @GetMapping("/{id}")
    ResponseEntity<StoreDtoWithProducts> getById(@PathVariable Long id);

    @Operation(summary = "Update a store")
    @PutMapping("/{id}")
    ResponseEntity<Void> updateStore(@PathVariable Long id, @RequestBody StoreDto storeDto);

    @Operation(summary = "Create a store")
    @PostMapping()
    ResponseEntity<Void> createStore( @RequestBody StoreDto storeDto);

    @Operation(summary = "Delete a store")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStore(@PathVariable Long id);

}
