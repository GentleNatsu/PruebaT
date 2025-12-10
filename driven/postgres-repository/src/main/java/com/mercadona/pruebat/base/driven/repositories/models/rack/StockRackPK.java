package com.mercadona.pruebat.base.driven.repositories.models.rack;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public  class StockRackPK implements Serializable {

    private Long productId;
    private Long rackId;
    private Long storeId;

}