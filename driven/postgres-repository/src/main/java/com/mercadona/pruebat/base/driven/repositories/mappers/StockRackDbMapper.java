package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.driven.repositories.models.rack.StockRackMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductDbMapper.class)
public interface StockRackDbMapper {


    @Mapping(source = "productMO", target ="product")
    StockRack toDomain(StockRackMO stockRackMO);

    StockRackMO toDb(StockRack stockRack);


}
