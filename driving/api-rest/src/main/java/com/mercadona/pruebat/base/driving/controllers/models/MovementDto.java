package com.mercadona.pruebat.base.driving.controllers.models;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovementDto {

    @CsvBindByName(column = "product_id",required = true)
    private Long productId;
    @CsvBindByName(column = "movement_type")
    private String  type;
    @CsvBindByName(column = "quantity")
    private Integer quantity;


}
