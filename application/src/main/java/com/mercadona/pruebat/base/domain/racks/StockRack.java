package com.mercadona.pruebat.base.domain.racks;


import com.mercadona.pruebat.base.domain.products.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRack {

    private Long rackId;
    private Long productId;
    private Long storeId;
    private Integer quantity;

    private Product product;
}
