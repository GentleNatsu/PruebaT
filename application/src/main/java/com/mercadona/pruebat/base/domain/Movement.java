package com.mercadona.pruebat.base.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movement {

    private Long productId;
    private String type;
    private Integer quantity;

}
