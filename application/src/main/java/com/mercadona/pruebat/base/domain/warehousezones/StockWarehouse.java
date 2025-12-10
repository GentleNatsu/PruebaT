package com.mercadona.pruebat.base.domain.warehousezones;


import com.mercadona.pruebat.base.domain.products.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockWarehouse {

    private Long warehouseId;
    private Long productId;
    private Long storeId;
    private Integer quantity;

    private Product product;

    public boolean hasStock() {
        return quantity != null && quantity > 0;
    }

}
