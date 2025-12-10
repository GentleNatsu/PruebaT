package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.WarehouseZoneDbPort;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;
import com.mercadona.pruebat.base.driven.repositories.WarehouseZoneRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.WarehouseZoneDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class WarehouseZoneDbAdapter implements WarehouseZoneDbPort {

    private final WarehouseZoneRepository repository;
    private final WarehouseZoneDbMapper dbMapper;

    @Override
    public void save(WarehouseZone warehouseZone) {
        repository.save(dbMapper.toDb(warehouseZone));
    }

    @Override
    public List<WarehouseZone> getWarehouseZonesByStore(Long id) {
        return repository.findAllByStoreId(id).stream().map(dbMapper::toDomain).toList();
    }

    @Override
    public void deleteByStoreId(Long id) {
        repository.deleteByStoreId(id);
    }
}
