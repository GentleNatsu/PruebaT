package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface StoreDbMapper {

  default MercadonaPage<Store> toDomain(Page<StoreMO> pageMO) {
    var page = pageMO.map(this::toDomain);
    return MercadonaPage.of(page);
  }

  Store toDomain(StoreMO storeMO);

  StoreMO toDb(Store store);
}
