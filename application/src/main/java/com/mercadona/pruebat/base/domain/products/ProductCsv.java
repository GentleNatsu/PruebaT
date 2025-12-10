package com.mercadona.pruebat.base.domain.products;


import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCsv {

    private Long productId;
    private String productName;
    private Long storageId;
    private String storageType;
    private Integer quantity;

    public ProductCsv(StockWarehouse stockWarehouse) {
        this.productId = stockWarehouse.getProductId();
        this.productName = stockWarehouse.getProduct().getName();
        this.storageId = stockWarehouse.getWarehouseId();
        this.storageType = "Almacen";
        this.quantity = stockWarehouse.getQuantity();
    }

    public ProductCsv(StockRack stockRack) {
        this.productId = stockRack.getProductId();
        this.productName = stockRack.getProduct().getName();
        this.storageId = stockRack.getRackId();
        this.storageType = "Modulo";
        this.quantity = stockRack.getQuantity();
    }

    public String getLine(){
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(productId);
        stringBuilder.append(";");
        stringBuilder.append(productName);
        stringBuilder.append(";");
        stringBuilder.append(storageId);
        stringBuilder.append(";");
        stringBuilder.append(storageType);
        stringBuilder.append(";");
        stringBuilder.append(quantity);
        return stringBuilder.toString();
    }

}
