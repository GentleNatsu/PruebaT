package com.mercadona.pruebat.base.driving.controllers.models.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDtoUpdate {

  private Long storeId;
  private String description;
  private String address;
}
 