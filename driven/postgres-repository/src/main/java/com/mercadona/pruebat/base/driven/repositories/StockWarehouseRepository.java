package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.warehouse.StockWarehouseMO;
import com.mercadona.pruebat.base.driven.repositories.models.warehouse.StockWarehousePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface StockWarehouseRepository extends JpaRepository<StockWarehouseMO, StockWarehousePK> {

    @Query("""
            SELECT s from StockWarehouseMO s join fetch s.productMO where s.warehouseId = :id
            """)
    Set<StockWarehouseMO> findAllByWarehouseId(Long id);

    @Query("""
            SELECT s from StockWarehouseMO s join fetch s.productMO where s.warehouseId in :ids
            """)
    Set<StockWarehouseMO> findAllByWarehouseIds(Set<Long> ids);

    void deleteByWarehouseId(Long warehouseId);
}
