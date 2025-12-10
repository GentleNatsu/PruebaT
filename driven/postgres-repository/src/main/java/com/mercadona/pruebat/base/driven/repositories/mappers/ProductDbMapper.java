package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.SectionType;
import com.mercadona.pruebat.base.domain.products.Product;
import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDbMapper {

  @Mapping(source = "section", target = "sectionType")
  Product toDomain(ProductMO productMO);

  @Mapping(target = "section", source = "sectionType")
  ProductMO toDb(Product product);

  default SectionType toSectionType(String section) {
    return SectionType.getTipo(section);
  }

  default String toSectionType(SectionType section) {
    if (section == null || SectionType.NONE.equals(section)) {
      return null;
    }
    return section.getCodigo();
  }
}
