package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;

import java.util.List;

public interface WarehouseZoneDbPort {

    void save(WarehouseZone warehouseZone);

    List<WarehouseZone> getWarehouseZonesByStore(Long id);


    void deleteByStoreId(Long id);
}
