package com.mercadona.pruebat.base.driven.repositories.models.rack;


import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "racks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RackMO {

    @Id
    @Column(name = "rack_id")
    private Long rackId;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "section")
    private String section;
    @Column(name = "store_id")
    private Long storeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", insertable = false, updatable = false)
    private StoreMO storeMO;

}
