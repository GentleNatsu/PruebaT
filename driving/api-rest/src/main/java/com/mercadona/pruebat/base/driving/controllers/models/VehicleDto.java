package com.mercadona.pruebat.base.driving.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private Long vehicleId;
    private Long storeId;
    private String type;
    private Integer capacity;

}
