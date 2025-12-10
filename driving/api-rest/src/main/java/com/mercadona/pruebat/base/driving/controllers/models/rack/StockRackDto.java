package com.mercadona.pruebat.base.driving.controllers.models.rack;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRackDto {

    private Long productId;
    private Long storeId;
    private String productDescription;
    private String productSection;
    private Integer quantity;



}
