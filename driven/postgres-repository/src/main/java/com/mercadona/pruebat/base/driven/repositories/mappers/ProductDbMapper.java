package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = OrderDbMapper.class)
public interface ProductDbMapper {

  default MercadonaPage<Product> toDomain(Page<ProductMO> pageMO) {
    var page = pageMO.map(this::toDomain);
    return MercadonaPage.of(page);
  }

  Product toDomain(ProductMO productMO);

  ProductMO toDb(Product product);
}
