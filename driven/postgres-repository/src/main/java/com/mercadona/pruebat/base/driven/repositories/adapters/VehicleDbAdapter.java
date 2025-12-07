package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.VehicleDbPort;
import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import com.mercadona.pruebat.base.driven.repositories.VehicleRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.VehicleDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class VehicleDbAdapter implements VehicleDbPort {

    private final VehicleRepository repository;
    private final VehicleDbMapper dbMapper;

    @Override
    public Set<Vehicle> getVehiclesByStore(Long id) {
        return repository.findAllByStoreId(id).stream().map(dbMapper::toDomain).collect(Collectors.toSet());
    }

    @Override
    public Map<Long, List<Vehicle>> getVehiclesByStores(Set<Long> ids) {
        return repository.findAllByStoreIds(ids).stream().map(dbMapper::toDomain)
                .collect(Collectors.groupingBy(Vehicle::getStoreId));
    }
}
