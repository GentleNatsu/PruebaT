package com.mercadona.pruebat.base.application.services.stores;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.ports.driven.StoreDbPort;
import com.mercadona.pruebat.base.application.ports.driven.StoreProductDbPort;
import com.mercadona.pruebat.base.application.ports.driven.VehicleDbPort;
import com.mercadona.pruebat.base.application.ports.driving.StoresPort;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreProduct;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;
import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoresAdapter implements StoresPort {

    private final StoreDbPort storeDbPort;
    private final VehicleDbPort vehicleDbPort;
    private final StoreProductDbPort storeProductDbPort;

    @Override
    public MercadonaPage<Store> getAll(StoreQuery query) {
        var stores = storeDbPort.getAll(query);
        var storeIds = stores.getContent().stream().map(Store::getStoreId).collect(Collectors.toSet());
        var mapVehicles = vehicleDbPort.getVehiclesByStores(storeIds);
        var mapProducts = storeProductDbPort.getProductsByStores(storeIds);
        stores.getContent().forEach(store -> setVehicleAndProduct(store, mapVehicles, mapProducts));
        return stores;
    }

    private void setVehicleAndProduct(Store store, Map<Long, List<Vehicle>> mapVehicles, Map<Long,
            List<StoreProduct>> mapProducts) {
        store.setProducts(mapProducts.get(store.getStoreId()));
        store.setVehicles(mapVehicles.get(store.getStoreId()));
    }

    @Override
    public Store get(Long id) {
        var store = getStoreIfExists(id);
        var vehicles = vehicleDbPort.getVehiclesByStore(id);
        var storeProducts = storeProductDbPort.getProductsByStore(id);
        store.setVehicles(vehicles);
        store.setProducts(storeProducts);
        return store;
    }

    private Store getStoreIfExists(Long id) {
        return storeDbPort.get(id).orElseThrow(() -> new PruebaTeException(ErrorCode.PROVETA_ERROR, id));
    }

    @Override
    public void update(Long id, Store store) {
        store.setStoreId(id);
        storeDbPort.save(store);
        store.getVehicles().forEach(v -> v.setStoreId(id));
        vehicleDbPort.saveAll(store.getVehicles());
    }

    @Override
    public void create(Store store) {
        var storeId = storeDbPort.save(store);
        store.getVehicles().forEach(v -> v.setStoreId(storeId));
        vehicleDbPort.saveAll(store.getVehicles());
    }

    @Override
    public void delete(Long id) {
        vehicleDbPort.deleteByStoreId(id);
        storeProductDbPort.deleteByStoreId(id);
        storeDbPort.delete(id);
    }
}
