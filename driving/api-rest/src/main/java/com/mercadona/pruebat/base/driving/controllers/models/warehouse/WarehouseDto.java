package com.mercadona.pruebat.base.driving.controllers.models.warehouse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDto {

    private Long warehouseId;
    private Integer capacity;
    private String description;
}
