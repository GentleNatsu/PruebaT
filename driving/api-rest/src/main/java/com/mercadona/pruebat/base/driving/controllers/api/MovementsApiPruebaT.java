package com.mercadona.pruebat.base.driving.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Tag(name = "Movements Api", description = "Movements api")
@RequestMapping("/api/v1/movements")
public interface MovementsApiPruebaT {

    @Operation(summary = "Process movements file")
    @PostMapping(path = "/store/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Void> processMovements(@PathVariable Long id, @RequestBody MultipartFile file);


}
