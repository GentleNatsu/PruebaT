package com.mercadona.pruebat.base.domain.warehousezones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseZone {

    private Long warehouseId;
    private Integer capacity;
    private Long storeId;
    private String description;
    private List<StockWarehouse> stockWarehouses;

    public WarehouseZone(Long storeId) {
        this.storeId = storeId;
        capacity = 100;
        description = "Zona de almacenaje 1";
    }

    public List<StockWarehouse> getValidStocks() {
        if (stockWarehouses == null) {
            return Collections.emptyList();
        }
        return stockWarehouses.stream().filter(StockWarehouse::hasStock).toList();
    }


}
