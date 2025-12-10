package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.SectionType;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.driven.repositories.models.rack.RackMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RackDbMapper {


    @Mapping(source = "section", target = "section")
    Rack toDomain(RackMO rackMO);

    @Mapping(source = "section", target = "section")
    RackMO toDb(Rack rack);

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
