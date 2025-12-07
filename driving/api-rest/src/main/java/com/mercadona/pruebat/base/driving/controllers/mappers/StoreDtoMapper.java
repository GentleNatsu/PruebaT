package com.mercadona.pruebat.base.driving.controllers.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoWithProducts;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreQueryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreDtoMapper {

    @Autowired
    MercadonaPageResponseBuilder mer;

    public abstract StoreDto toDto(Store store);

    public abstract StoreDtoWithProducts toDtoWithProducts(Store store);


    public abstract Store toDomain(StoreDto storeDto);

    public abstract StoreQuery toDomain(StoreQueryDto queryDto);

    @Mapping(source = ".", target = "pagination")
    @Mapping(source = "content", target = "data")
    public abstract PageResponseDto<StoreDtoWithProducts> toDto(MercadonaPage<Store> page);

    public Pagination toPagination(MercadonaPage<Store> page) {

        return mer.builder().requestedPage(page.getNumber())
                .requestedSize(page.getSize())
                .retrievedResults(page.getNumberOfElements())
                .totalResults(page.getTotalElements())
                .buildNextPage(page.getNumber(), page.getSize(), page.getTotalPages())
                .buildPreviousPage(page.getNumber(), page.getSize())
                .build();

    }
}
 