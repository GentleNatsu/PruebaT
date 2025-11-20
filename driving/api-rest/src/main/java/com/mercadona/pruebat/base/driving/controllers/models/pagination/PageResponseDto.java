package com.mercadona.pruebat.base.driving.controllers.models.pagination;

import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {

    private Pagination pagination;
    private List<T> data;

}
 