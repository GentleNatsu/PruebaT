package com.mercadona.pruebat.base.application.services.stores;

import com.mercadona.pruebat.base.domain.products.ProductCsv;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor
@Data
public class CsvProcessor {

    public static final String HEADERS = "product_id;product_name;location_id;location_type;quantity";
    private final Store store;


    public String getCsv() {
        StringBuilder csvStringBuilder = getStringBuilderWithHeaders();
        var productCsvWarehouse = getWarehouseToPrint();
        var noStockWarehouseStock = getWarehouseStocksAt0();
        var productCsvRack = getRacksReadyToBeReplenished(noStockWarehouseStock);

        productCsvWarehouse.forEach(productCsv -> appendLine(productCsv, csvStringBuilder));
        productCsvRack.forEach(productCsv -> appendLine(productCsv, csvStringBuilder));


        return csvStringBuilder.toString();

    }

    private List<ProductCsv> getRacksReadyToBeReplenished(List<StockWarehouse> noStockWarehouseStock) {
        return store.getRacks().stream().map(Rack::getStockRacks).filter(Objects::nonNull).flatMap(Collection::stream)
                .filter(stockRack -> isPrintable(noStockWarehouseStock, stockRack)).map(ProductCsv::new).toList();
    }

    private boolean isPrintable(List<StockWarehouse> noStockWarehouseStock, StockRack stockRack) {
        return stockRack.getQuantity() > 0 || hasStockInWarehouse(stockRack,
                noStockWarehouseStock);
    }

    private List<StockWarehouse> getWarehouseStocksAt0() {
        return store.getWarehouseZones().stream().map(WarehouseZone::getStockWarehouses)
                .flatMap(Collection::stream).filter(not(StockWarehouse::hasStock)).toList();
    }

    private static StringBuilder getStringBuilderWithHeaders() {
        StringBuilder csvStringBuilder = new StringBuilder();
        csvStringBuilder.append(HEADERS);
        csvStringBuilder.append("\n");
        return csvStringBuilder;
    }

    private void appendLine(ProductCsv productCsv, StringBuilder stringBuilder) {
        stringBuilder.append(productCsv.getLine());
        stringBuilder.append("\n");
    }

    private boolean hasStockInWarehouse(StockRack stockRack, List<StockWarehouse> noStockWarehouseStock) {
        return !noStockWarehouseStock.stream().map(StockWarehouse::getProductId).toList().contains(stockRack.getProductId());
    }

    private List<ProductCsv> getWarehouseToPrint() {
        return store.getWarehouseZones().stream().map(WarehouseZone::getValidStocks).flatMap(Collection::stream).map(ProductCsv::new).toList();
    }

}
