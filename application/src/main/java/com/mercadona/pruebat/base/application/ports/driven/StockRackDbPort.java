package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StockRackDbPort {

    List<StockRack> getStocksByRackIds(Set<Long> id);

    void deleteStocks(List<StockRack> rackStocks);

    Map<Long, List<StockRack>> getStocksByRackIdsAsMap(Set<Long> id);

}
