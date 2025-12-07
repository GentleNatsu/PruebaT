package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.stores.StoreProduct;
import com.mercadona.pruebat.base.domain.vehicles.Vehicle;
import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreProductsMO;
import com.mercadona.pruebat.base.driven.repositories.models.vehicles.VehicleMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreProductsDbMapper {


    StoreProduct toDomain(StoreProductsMO storeProductsMO);

    StoreProductsMO toDb(StoreProduct storeProduct);
}
