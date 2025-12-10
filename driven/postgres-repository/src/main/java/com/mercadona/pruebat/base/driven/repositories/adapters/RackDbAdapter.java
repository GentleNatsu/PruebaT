package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.RackDbPort;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.driven.repositories.RackRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.RackDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RackDbAdapter implements RackDbPort {

    private final RackRepository repository;
    private final RackDbMapper dbMapper;


    @Override
    public List<Rack> getRacksByStore(Long id) {
        return repository.findAllByStoreId(id).stream().map(dbMapper::toDomain).toList();
    }

    @Override
    public Map<Long, List<Rack>> getRacksByStores(Set<Long> ids) {
        return repository.findAllByStoreIds(ids).stream().map(dbMapper::toDomain)
                .collect(Collectors.groupingBy(Rack::getStoreId));
    }

    @Override
    public void deleteByStoreId(Long id) {
        repository.deleteByStoreId(id);
    }

    @Override
    public void saveAll(List<Rack> vehicles) {
        var vehiclesMO = vehicles.stream().map(dbMapper::toDb).toList();
        repository.saveAll(vehiclesMO);
    }

}
