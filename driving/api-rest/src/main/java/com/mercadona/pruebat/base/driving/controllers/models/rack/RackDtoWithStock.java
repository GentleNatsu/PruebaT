package com.mercadona.pruebat.base.driving.controllers.models.rack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RackDtoWithStock {

    private Long rackId;
    private Integer capacity;
    private String section;

    private List<StockRackDto> stockRackDtos;
}
