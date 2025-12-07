package com.mercadona.pruebat.base.application.services.stores;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.ports.driven.StoreProductDbPort;
import com.mercadona.pruebat.base.application.ports.driven.StoreDbPort;
import com.mercadona.pruebat.base.application.ports.driven.VehicleDbPort;
import com.mercadona.pruebat.base.application.ports.driving.StoresPort;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreProduct;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;
import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class StoresAdapter implements StoresPort {

    private final StoreDbPort storeDbPort;
    private final VehicleDbPort vehicleDbPort;
    private final StoreProductDbPort storeProductDbPort;

    @Override
    public MercadonaPage<Store> getAll(StoreQuery query) {
        return storeDbPort.getAll(query);
    }

    @Override
    public Store get(Long id) {
        var store = getStoreIfExists(id);
        Set<Vehicle> vehicles = vehicleDbPort.getVehiclesByStore(id);
        Set<StoreProduct> storeProducts = storeProductDbPort.getProductsByStore(id);
        return store;
    }

    private Store getStoreIfExists(Long id) {
        return storeDbPort.get(id).orElseThrow(() -> new PruebaTeException(ErrorCode.PROVETA_ERROR, id));
    }

    @Override
    public void update(Long id, Store store) {
        store.setStoreId(id);
        storeDbPort.save(store);
    }

    @Override
    public void create(Store store) {
        storeDbPort.save(store);
    }

    @Override
    public void delete(Long id) {
        storeDbPort.delete(id);

    }
}
