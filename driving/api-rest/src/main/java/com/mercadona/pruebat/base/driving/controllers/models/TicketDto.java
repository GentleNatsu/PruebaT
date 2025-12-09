package com.mercadona.pruebat.base.driving.controllers.models;

import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;

import java.util.List;

public class TicketDto {

    private Long id;
    private String customerId;
    private String storeId;
    private String storeName;
    private List<ProductDto> productDtoList;
    private Integer price;

}
