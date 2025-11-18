package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductMO, Long>, JpaSpecificationExecutor<ProductMO> {
  @Query("""
            SELECT DISTINCT p FROM ProductMO p
            LEFT JOIN FETCH p.orderLines ol
            LEFT JOIN FETCH ol.order
            WHERE p.id IN :ids
        """)
  Collection<ProductMO> findAllByIdInWithOrderLinesAndOrders(List<Long> ids);
}
