package com.mercadona.pruebat.base.driven.repositories.models.stores;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public  class StoreProductsPK implements Serializable {

    private Long productId;
    private Long storeId;

}