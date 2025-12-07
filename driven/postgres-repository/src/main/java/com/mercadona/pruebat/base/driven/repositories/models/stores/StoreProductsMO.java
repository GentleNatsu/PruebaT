package com.mercadona.pruebat.base.driven.repositories.models.stores;

import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(StoreProductsPK.class)
public class StoreProductsMO {

    @Id
    @Column(name = "product_id")
    private Long productId;
    @Id
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductMO product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", insertable = false, updatable = false)
    private StoreMO storeMO;


}
