package com.mercadona.pruebat.base.driving.controllers.models.store;

import com.mercadona.pruebat.base.driving.controllers.models.rack.RackDtoWithStock;
import com.mercadona.pruebat.base.driving.controllers.models.warehouse.WarehouseDtoWithStock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDtoExtended {

    private Long storeId;
    private String description;
    private String address;

    private Set<RackDtoWithStock> rackDtos;
    private Set<WarehouseDtoWithStock> warehouseDtos;

}
 