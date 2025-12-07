package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import com.mercadona.pruebat.base.driven.repositories.models.vehicles.VehicleMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleDbMapper {


    Vehicle toDomain(VehicleMO vehicleMO);

    VehicleMO toDb(Vehicle vehicle);
}
