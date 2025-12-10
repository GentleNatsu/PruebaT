package com.mercadona.pruebat.base.driven.repositories.models.rack;


import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock_rack")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(StockRackPK.class)
public class StockRackMO {

    @Id
    @Column(name = "rack_id")
    private Long rackId;
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
    @JoinColumn(name = "rack_id", referencedColumnName = "rack_id", insertable = false, updatable = false)
    private RackMO rackMO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductMO productMO;


}
