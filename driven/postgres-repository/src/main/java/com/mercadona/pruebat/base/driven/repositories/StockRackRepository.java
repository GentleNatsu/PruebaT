package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.rack.RackMO;
import com.mercadona.pruebat.base.driven.repositories.models.rack.StockRackMO;
import com.mercadona.pruebat.base.driven.repositories.models.rack.StockRackPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface StockRackRepository extends JpaRepository<StockRackMO, StockRackPK> {

    @Query("""
            SELECT s from StockRackMO s where s.rackId = :id
            """)
    Set<StockRackMO> findAllByRackId(Long id);

    @Query("""
            SELECT s from StockRackMO s where s.rackId in :ids
            """)
    Set<StockRackMO> findAllByRackIds(Set<Long> ids);

    void deleteByRackId(Long rackId);
}
