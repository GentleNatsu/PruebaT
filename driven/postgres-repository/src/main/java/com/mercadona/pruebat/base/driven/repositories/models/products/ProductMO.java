package com.mercadona.pruebat.base.driven.repositories.models.products;

import com.mercadona.pruebat.base.driven.repositories.models.orders.OrderLineMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductMO {
  @Id
  @Column(name = "product_id")
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "price")
  private Float price;
  @Column(name = "stock")
  private Integer stock;
  @Column(name = "created_at")
  private OffsetDateTime createdAt;

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private Set<OrderLineMO> orderLines;
}
