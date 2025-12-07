package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.stores.StoreProduct;
import com.mercadona.pruebat.base.domain.vehicles.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StoreProductDbPort {

    List<StoreProduct> getProductsByStore(Long id);

    Map<Long, List<StoreProduct>> getProductsByStores(Set<Long> ids);

}
