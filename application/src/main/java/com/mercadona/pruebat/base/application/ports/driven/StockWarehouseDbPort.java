package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StockWarehouseDbPort {

    List<StockWarehouse> getStocksByWarehouseIds(Set<Long> id);

    void deleteStocks(List<StockWarehouse> rackStocks);

    Map<Long, List<StockWarehouse>> getStocksByWarehouseIdsAsMap(Set<Long> id);
}
