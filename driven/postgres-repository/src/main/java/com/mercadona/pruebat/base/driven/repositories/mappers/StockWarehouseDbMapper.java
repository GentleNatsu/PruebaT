package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import com.mercadona.pruebat.base.driven.repositories.models.warehouse.StockWarehouseMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductDbMapper.class)
public interface StockWarehouseDbMapper {


    @Mapping(source = "productMO", target = "product")
    StockWarehouse toDomain(StockWarehouseMO stockWarehouseMO);

    StockWarehouseMO toDb(StockWarehouse stockWarehouse);


}
