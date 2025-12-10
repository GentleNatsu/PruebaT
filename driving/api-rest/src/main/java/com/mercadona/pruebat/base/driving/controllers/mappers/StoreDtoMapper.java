package com.mercadona.pruebat.base.driving.controllers.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.commons.rest.api.model.Pagination;
import com.mercadona.framework.cna.lib.web.builders.MercadonaPageResponseBuilder;
import com.mercadona.pruebat.base.domain.SectionType;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.rack.RackDto;
import com.mercadona.pruebat.base.driving.controllers.models.rack.RackDtoWithStock;
import com.mercadona.pruebat.base.driving.controllers.models.rack.StockRackDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoExtended;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoUpdate;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreQueryDto;
import com.mercadona.pruebat.base.driving.controllers.models.warehouse.StockWarehouseDto;
import com.mercadona.pruebat.base.driving.controllers.models.warehouse.WarehouseDtoWithStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StoreDtoMapper {

    @Autowired
    MercadonaPageResponseBuilder mer;

    @Mapping(source = "racks", target = "rackDtos")
    public abstract StoreDto toDtoWithRacks(Store store);

    @Mapping(source = "racks", target = "rackDtos", qualifiedByName = "withStock")
    @Mapping(source = "warehouseZones", target = "warehouseDtos")
    public abstract StoreDtoExtended toDtoWithStocks(Store store);

    @Mapping(source = "section", target = "section")
    public abstract RackDto toDto(Rack rack);

    @Mapping(source = "product.name", target = "productDescription")
    @Mapping(source = "product.sectionType", target = "productSection")
    public abstract StockWarehouseDto toDto(StockWarehouse stockWarehouse);

    @Mapping(source = "product.name", target = "productDescription")
    @Mapping(source = "product.sectionType", target = "productSection")
    public abstract StockRackDto toDto(StockRack stockRack);

    @Named("withStock")
    @Mapping(source = "section", target = "section")
    @Mapping(source = "stockRacks", target = "stockRackDtos")
    public abstract RackDtoWithStock toDtoWithStock(Rack rack);

    @Mapping(source = "stockWarehouses", target = "stockWarehouseDtos")
    public abstract WarehouseDtoWithStock toDto(WarehouseZone rack);

    public String toSectionType(SectionType section) {
        if (section == null || SectionType.NONE.equals(section)) {
            return null;
        }
        return section.name();
    }

    public SectionType toSectionType(String section) {
        return SectionType.getTipo(section);
    }


    @Mapping(source = "rackDtos", target = "racks")
    public abstract Store toDomainCreate(StoreDto storeDto);

    public abstract Store toDomainUpdate(StoreDtoUpdate storeDto);


    public abstract StoreQuery toDomain(StoreQueryDto queryDto);

    @Mapping(source = ".", target = "pagination")
    @Mapping(source = "content", target = "data")
    public abstract PageResponseDto<StoreDto> toDto(MercadonaPage<Store> page);

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
 