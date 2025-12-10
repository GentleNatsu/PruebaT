package com.mercadona.pruebat.base.driving.controllers.models.warehouse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockWarehouseDto {

    private Long productId;
    private Long storeId;
    private Integer quantity;
    private String productDescription;
    private String productSection;

}
