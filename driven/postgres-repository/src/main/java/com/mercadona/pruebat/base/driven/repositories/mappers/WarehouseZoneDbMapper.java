package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.SectionType;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;
import com.mercadona.pruebat.base.driven.repositories.models.rack.RackMO;
import com.mercadona.pruebat.base.driven.repositories.models.warehouse.WarehouseZoneMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WarehouseZoneDbMapper {


    WarehouseZone toDomain(WarehouseZoneMO warehouseZoneMO);

    WarehouseZoneMO toDb(WarehouseZone warehouseZone);

}
