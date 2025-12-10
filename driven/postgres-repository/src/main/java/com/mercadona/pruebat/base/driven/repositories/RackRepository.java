package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.rack.RackMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RackRepository extends JpaRepository<RackMO, Long> {

    @Query("""
            SELECT r from RackMO r where r.storeId = :id
            """)
    Set<RackMO> findAllByStoreId(Long id);

    @Query("""
            SELECT r from RackMO r where r.storeId in :ids
            """)
    Set<RackMO> findAllByStoreIds(Set<Long> ids);

    void deleteByStoreId(Long storeId);
}
