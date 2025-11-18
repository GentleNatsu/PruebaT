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
  @Column(name = "customer_name")
  private String customerName;
  @Column(name = "customer_email")
  private String customerEmail;
  @Column(name = "order_date")
  private String orderDate;
  @Column(name = "status")
  private String status;
  @Column(name = "total")
  private Float total;

  @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
  private Set<OrderLineMO> orderLines;
}
