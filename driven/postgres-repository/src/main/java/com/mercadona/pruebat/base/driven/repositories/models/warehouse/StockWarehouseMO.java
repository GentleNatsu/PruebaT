package com.mercadona.pruebat.base.driven.repositories.models.warehouse;


import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import com.mercadona.pruebat.base.driven.repositories.models.rack.RackMO;
import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock_warehouse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(StockWarehousePK.class)
public class StockWarehouseMO {

    @Id
    @Column(name = "warehouse_id")
    private Long warehouseId;
    @Id
    @Column(name = "product_id")
    private Long productId;
    @Id
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "quantity")
    private Integer quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", insertable = false, updatable = false)
    private StoreMO storeMO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id", insertable = false, updatable = false)
    private WarehouseZoneMO warehouseZoneMO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductMO productMO;






}
