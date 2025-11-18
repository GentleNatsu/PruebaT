package com.mercadona.pruebat.base.driven.repositories.specifications;

import com.mercadona.pruebat.base.domain.products.ProductQuery;
import com.mercadona.pruebat.base.driven.repositories.models.products.ProductMO;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<ProductMO> {

  private List<Predicate> predicates;
  private final ProductQuery query;

  public ProductSpecification(ProductQuery query) {
    this.query = query;
  }

  @Override
  public Predicate toPredicate(Root<ProductMO> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    predicates = new ArrayList<>();
    searchByName(root, cb);
    searchByDescription(root, cb);
    searchByPrice(root, cb);
    orderBy(root, cb, cq);
    return cb.and(predicates.toArray(new Predicate[0]));
  }

  private void orderBy(Root<ProductMO> root, CriteriaBuilder cb, CriteriaQuery<?> cq) {
    if (query.getOrder() != null) {
      if (query.isDescendent()) {
        cq.orderBy(cb.desc(root.get(query.getAttributeForOrderBy())));
      } else {
        cq.orderBy(cb.asc(root.get(query.getAttributeForOrderBy())));
      }
    } else {
      List<Order> orders = new ArrayList<>();
      orders.add(cb.desc(root.get("createdAt")));
      cq.orderBy(orders);
    }
  }

  private void searchByPrice(Root<ProductMO> root, CriteriaBuilder cb) {
    if (query.getPrice() != null) {
      var filterPrice = cb.equal(root.get("price"), query.getPrice());
      predicates.add(filterPrice);
    }
  }

  private void searchByDescription(Root<ProductMO> root, CriteriaBuilder cb) {
    if (query.getDescription() != null) {
      var filterDescription = cb.like(cb.lower(root.get("description")), "%" + query.getDescription().toLowerCase() + "%");
      predicates.add(filterDescription);
    }
  }

  private void searchByName(Root<ProductMO> root, CriteriaBuilder cb) {
    if (query.getName() != null) {
      var filterName = cb.like(cb.lower(root.get("name")), "%" + query.getName().toLowerCase() + "%");
      predicates.add(filterName);
    }
  }
}
