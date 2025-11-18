package com.mercadona.pruebat.base.driven.repositories.mappers;

import com.mercadona.pruebat.base.domain.orders.Order;
import com.mercadona.pruebat.base.domain.orders.OrderLine;
import com.mercadona.pruebat.base.driven.repositories.models.orders.OrderLineMO;
import com.mercadona.pruebat.base.driven.repositories.models.orders.OrderMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDbMapper {

  Order toDomain(OrderMO orderMO);

  OrderLine toDomain(OrderLineMO orderLineMO);
}
