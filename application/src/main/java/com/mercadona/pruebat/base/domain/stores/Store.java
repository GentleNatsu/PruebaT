package com.mercadona.pruebat.base.domain.stores;

import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    private Long storeId;
    private String description;
    private String address;

    private List<StoreProduct> products;
    private List<Vehicle> vehicles;


}
