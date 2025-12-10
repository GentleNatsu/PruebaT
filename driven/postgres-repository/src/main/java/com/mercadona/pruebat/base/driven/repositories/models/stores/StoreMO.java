package com.mercadona.pruebat.base.driven.repositories.models.stores;

import com.mercadona.pruebat.base.driven.repositories.models.rack.RackMO;
import com.mercadona.pruebat.base.driven.repositories.models.warehouse.StockWarehouseMO;
import com.mercadona.pruebat.base.driven.repositories.models.warehouse.WarehouseZoneMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.Set;

@Entity
@Table(name = "stores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class StoreMO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(
            name = "user_seq_gen",
            sequenceName = "stores_store_id_seq", // Nombre que me crea solo el puto bigserial, no seas tonto carlitos
            allocationSize = 1
    )    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "storeMO", fetch = FetchType.LAZY)
    @NotAudited
    private Set<RackMO> rackMOS;

    @OneToMany(mappedBy = "storeMO", fetch = FetchType.LAZY)
    @NotAudited
    private Set<WarehouseZoneMO> warehouseZoneMOS;


}
