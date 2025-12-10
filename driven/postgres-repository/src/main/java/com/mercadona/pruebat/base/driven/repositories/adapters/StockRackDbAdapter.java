package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.StockRackDbPort;
import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import com.mercadona.pruebat.base.driven.repositories.StockRackRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.StockRackDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StockRackDbAdapter implements StockRackDbPort {

    private final StockRackRepository repository;
    private final StockRackDbMapper dbMapper;

    @Override
    public List<StockRack> getStocksByRackIds(Set<Long> id) {
        return repository.findAllByRackIds(id).stream().map(dbMapper::toDomain).toList();
    }

    @Override
    public void deleteStocks(List<StockRack> stockRacks) {
        var stockRackMOs = stockRacks.stream().map(dbMapper::toDb).toList();
        repository.deleteAll(stockRackMOs);
    }

    @Override
    public Map<Long, List<StockRack>> getStocksByRackIdsAsMap(Set<Long> id) {
        return repository.findAllByRackIds(id).stream().map(dbMapper::toDomain).collect(Collectors.groupingBy(StockRack::getRackId));
    }
}
