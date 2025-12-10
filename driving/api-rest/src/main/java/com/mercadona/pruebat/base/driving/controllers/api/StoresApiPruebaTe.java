package com.mercadona.pruebat.base.driving.controllers.api;

import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoExtended;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoUpdate;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreQueryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Tag(name="Stores Api", description = "Stores api")
@RequestMapping("/api/v1/stores")
public interface StoresApiPruebaTe {

    @Operation(summary = "Get all stores")
    @GetMapping
    ResponseEntity<PageResponseDto<StoreDto>> getAll(StoreQueryDto queryDto);

    @Operation(summary = "Get one store by id")
    @GetMapping("/{id}")
    ResponseEntity<StoreDto> getById(@PathVariable Long id);

    @Operation(summary = "Update a store")
    @PutMapping("/{id}")
    ResponseEntity<Void> updateStore(@PathVariable Long id, @RequestBody StoreDtoUpdate storeDto);

    @Operation(summary = "Create a store")
    @PostMapping()
    ResponseEntity<Void> createStore( @RequestBody StoreDto storeDto);

    @Operation(summary = "Delete a store")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStore(@PathVariable Long id);

    @Operation(summary = "Get stocks")
    @GetMapping("/{id}/stock")
    ResponseEntity<StoreDtoExtended> getStock(@PathVariable Long id);

    @Operation(summary = "Get gaps")
    @GetMapping("/{id}/gaps")
    ResponseEntity<StoreDtoExtended> getGaps(@PathVariable Long id);

    @RequestMapping(value = "/{id}/stock.csv")
   ResponseEntity<byte[]> getStockCsv(@PathVariable Long id);
}
