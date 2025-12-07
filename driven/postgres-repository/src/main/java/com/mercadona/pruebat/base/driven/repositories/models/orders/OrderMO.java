package com.mercadona.pruebat.base.driven.repositories.models.orders;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderMO {

  @Id
  @Column(name = "order_id")
  private Long id;
  @Column(name = "customer_id")
  private String customerId;
  @Column(name = "store_id")
  private String storeId;
  @Column(name = "address")
  private String address;
  @Column(name = "priority")
  private Integer priority;

  @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
  private Set<OrderLineMO> orderLines;
}
