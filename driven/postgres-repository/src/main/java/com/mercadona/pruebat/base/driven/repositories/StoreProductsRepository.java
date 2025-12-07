package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreProductsMO;
import com.mercadona.pruebat.base.driven.repositories.models.vehicles.VehicleMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface StoreProductsRepository extends JpaRepository<StoreProductsMO, Long> {

    @Query("""
            SELECT s from StoreProductsMO s
            join fetch s.product
            where s.storeId = :id
            """)
    Set<StoreProductsMO> findAllByStoreId(Long id);

    @Query("""
            SELECT s from StoreProductsMO s where s.storeId in :ids
            """)
    Set<StoreProductsMO> findAllByStoreIds(Set<Long> ids);
}
