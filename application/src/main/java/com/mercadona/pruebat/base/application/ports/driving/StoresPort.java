package com.mercadona.pruebat.base.application.ports.driving;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;

public interface StoresPort {

    MercadonaPage<Store> getAll(StoreQuery query);

    Store get(Long id);

    void update(Long id, Store store);

    void create(Store store);


    void delete(Long id);


}
