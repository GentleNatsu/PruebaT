package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.StockWarehouseDbPort;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import com.mercadona.pruebat.base.driven.repositories.StockWarehouseRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.StockWarehouseDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StockWarehouseDbAdapter implements StockWarehouseDbPort {

    private final StockWarehouseRepository repository;
    private final StockWarehouseDbMapper dbMapper;

    @Override
    public List<StockWarehouse> getStocksByWarehouseIds(Set<Long> id) {
        return repository.findAllByWarehouseIds(id).stream().map(dbMapper::toDomain).toList();
    }

    @Override
    public Map<Long, List<StockWarehouse>> getStocksByWarehouseIdsAsMap(Set<Long> id) {
        return repository.findAllByWarehouseIds(id).stream().map(dbMapper::toDomain).collect(Collectors.groupingBy(StockWarehouse::getWarehouseId));
    }

    @Override
    public void deleteStocks(List<StockWarehouse> stockRacks) {
        var stockRackMOs = stockRacks.stream().map(dbMapper::toDb).toList();
        repository.deleteAll(stockRackMOs);

    }
}
