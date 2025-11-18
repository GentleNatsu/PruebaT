package com.mercadona.pruebat.base.driven.repositories.models.orders;

import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_lines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineMO {
  @Id
  @Column(name = "line_id")
  private Long id;
  @Column(name = "order_id")
  private Long orderId;
  @Column(name = "product_id")
  private Long productId;
  @Column(name = "quantity")
  private Integer quantity;
  @Column(name = "unit_price")
  private Float unitPrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
  private ProductMO product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
  private OrderMO order;
}
