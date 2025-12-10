package com.mercadona.pruebat.base.driven.repositories.models.warehouse;

import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "warehouse_zone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseZoneMO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(
            name = "user_seq_gen",
            sequenceName = "warehouse_zone_warehouse_id_seq", // Nombre que me crea solo el puto bigserial, no seas tonto carlitos
            allocationSize = 1
    )@Column(name = "warehouse_id")
    private Long warehouseId;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "description")
    private String description;
    @Column(name = "store_id")
    private Long storeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", insertable = false, updatable = false)
    private StoreMO storeMO;

}
