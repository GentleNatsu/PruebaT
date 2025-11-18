package com.mercadona.pruebat.base.driving.controllers.models.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PageRequestDto {

    private Integer page;
    private Integer pageSize;
    private String order;

}
 