package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.warehouse.WarehouseZoneMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface WarehouseZoneRepository extends JpaRepository<WarehouseZoneMO, Long> {


    @Query("""
            SELECT r from WarehouseZoneMO r where r.storeId = :id
            """)
    Set<WarehouseZoneMO> findAllByStoreId(Long id);

    void deleteByStoreId(Long storeId);

}
