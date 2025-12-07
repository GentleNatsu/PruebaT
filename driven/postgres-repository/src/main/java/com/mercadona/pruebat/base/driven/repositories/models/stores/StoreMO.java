package com.mercadona.pruebat.base.driven.repositories.models.stores;

import com.mercadona.pruebat.base.driven.repositories.models.orders.OrderLineMO;
import com.mercadona.pruebat.base.driven.repositories.models.vehicles.VehicleMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "stores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreMO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "storeMO", fetch = FetchType.LAZY)
    private Set<StoreProductsMO> storeProductsMOS;
    @OneToMany(mappedBy = "storeMO", fetch = FetchType.LAZY)
    private Set<VehicleMO> vehicleMOS;


}
