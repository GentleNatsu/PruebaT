package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.StoreProductDbPort;
import com.mercadona.pruebat.base.application.ports.driven.VehicleDbPort;
import com.mercadona.pruebat.base.domain.stores.StoreProduct;
import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import com.mercadona.pruebat.base.driven.repositories.StoreProductsRepository;
import com.mercadona.pruebat.base.driven.repositories.VehicleRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.StoreProductsDbMapper;
import com.mercadona.pruebat.base.driven.repositories.mappers.VehicleDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StoreProductDbAdapter implements StoreProductDbPort {

    private final StoreProductsRepository repository;
    private final StoreProductsDbMapper dbMapper;

    @Override
    public List<StoreProduct> getProductsByStore(Long id) {
        return repository.findAllByStoreId(id).stream().map(dbMapper::toDomain).toList();
    }

    @Override
    public Map<Long, List<StoreProduct>> getProductsByStores(Set<Long> ids) {
        return repository.findAllByStoreIds(ids).stream().map(dbMapper::toDomain)
                .collect(Collectors.groupingBy(StoreProduct::getStoreId));
    }

    @Override
    public void deleteByStoreId(Long id) {
        repository.deleteByStoreId(id);

    }
}
