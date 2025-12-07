package com.mercadona.pruebat.base.domain.vehicles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private Long vehicleId;
    private Long storeId;
    private String type;
    private Integer capacity;
}
