package com.mercadona.pruebat.base.driving.controllers.models.pagination;

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

    private PaginationDto pagination;
    private List<T> data;

    public <D> PageResponseDto<D> map(Function<? super T, ? extends D> mapFunction){
        List<D> mappedList = data.stream().map(mapFunction).collect(Collectors.toList());
        return new PageResponseDto<>(pagination, mappedList);
    }
}
 