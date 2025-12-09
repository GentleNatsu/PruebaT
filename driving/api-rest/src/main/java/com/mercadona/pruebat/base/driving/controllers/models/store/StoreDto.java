package com.mercadona.pruebat.base.driving.controllers.models.store;

import com.mercadona.pruebat.base.driving.controllers.models.VehicleDto;
import com.mercadona.pruebat.base.driving.controllers.models.order.OrderLineDto;
import com.mercadona.pruebat.base.driving.controllers.models.product.ProductDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {

  private Long storeId;
  private String description;
  private String address;

  private Set<VehicleDto> vehicleDtos;
}
 