package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;

import java.util.Optional;

public interface StoreDbPort {

    MercadonaPage<Store> getAll(StoreQuery query);

    Optional<Store> get(Long id);

    Long save(Store store);

    void delete(Long id);
}
