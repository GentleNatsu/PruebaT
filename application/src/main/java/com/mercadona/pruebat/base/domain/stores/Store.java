package com.mercadona.pruebat.base.domain.stores;

import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    private Long storeId;
    private String description;
    private String address;

    private List<WarehouseZone> warehouseZones;
    private List<Rack> racks;


}
