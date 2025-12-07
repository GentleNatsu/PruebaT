package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.users.Roles;
import com.mercadona.pruebat.base.domain.users.User;
import com.mercadona.pruebat.base.driven.repositories.models.UserMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDbMapper {

    @Mapping(source = "rol", target = "roles")
    User toDomain(UserMO userMO);

    default Roles toDomain(String rol) {
        return Roles.getRole(rol);
    }

}
