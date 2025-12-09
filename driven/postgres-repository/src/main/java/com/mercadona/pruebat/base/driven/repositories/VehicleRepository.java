package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.vehicles.VehicleMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface VehicleRepository extends JpaRepository<VehicleMO, Long> {

    @Query("""
            SELECT v from VehicleMO v where v.storeId = :id
            """)
    Set<VehicleMO> findAllByStoreId(Long id);

    @Query("""
            SELECT v from VehicleMO v where v.storeId in :ids
            """)
    Set<VehicleMO> findAllByStoreIds(Set<Long> ids);

    void deleteByStoreId(Long storeId);
}
