package com.mercadona.pruebat.base.driving.controllers.models.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationDto {

    private Integer requestedPage;
    private Integer requestedSize;
    private Integer retrievedResults;
    private Long totalResults;
    private String nextPage;
    private String previousPage;
    private Integer totalPages;
}
 