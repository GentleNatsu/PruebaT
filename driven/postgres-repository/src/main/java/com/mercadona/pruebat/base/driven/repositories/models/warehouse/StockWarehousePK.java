package com.mercadona.pruebat.base.driven.repositories.models.warehouse;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class StockWarehousePK implements Serializable {

    private Long productId;
    private Long warehouseId;
    private Long storeId;

}
