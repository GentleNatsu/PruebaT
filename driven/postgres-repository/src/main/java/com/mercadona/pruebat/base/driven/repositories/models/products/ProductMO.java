package com.mercadona.pruebat.base.driven.repositories.models.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  @Column(name = "price")
  private Float price;
  @Column(name = "section")
  private String section;

}
