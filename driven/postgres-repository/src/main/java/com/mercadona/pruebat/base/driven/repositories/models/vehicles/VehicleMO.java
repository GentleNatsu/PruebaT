package com.mercadona.pruebat.base.driven.repositories.models.vehicles;

import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMO {

    @Id
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "type")
    private String type;
    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", insertable = false, updatable = false)
    private StoreMO storeMO;

}
