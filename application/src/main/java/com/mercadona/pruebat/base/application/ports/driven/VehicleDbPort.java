package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.vehicles.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface VehicleDbPort {

    List<Vehicle> getVehiclesByStore(Long id);

    Map<Long, List<Vehicle>> getVehiclesByStores(Set<Long> ids);
}
