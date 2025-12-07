package com.mercadona.pruebat.base.domain.stores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreProduct {

    private Long productId;
    private String productDescription;
    private Long storeId;
    private Integer quantity;
}
