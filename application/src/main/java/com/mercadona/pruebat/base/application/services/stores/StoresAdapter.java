package com.mercadona.pruebat.base.application.services.stores;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.ports.driven.*;
import com.mercadona.pruebat.base.application.ports.driving.StoresPort;
import com.mercadona.pruebat.base.domain.racks.Rack;
import com.mercadona.pruebat.base.domain.racks.StockRack;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;
import com.mercadona.pruebat.base.domain.warehousezones.StockWarehouse;
import com.mercadona.pruebat.base.domain.warehousezones.WarehouseZone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoresAdapter implements StoresPort {

    private final StoreDbPort storeDbPort;
    private final RackDbPort rackDbPort;
    private final StockRackDbPort stockRackDbPort;
    private final WarehouseZoneDbPort warehouseZoneDbPort;
    private final StockWarehouseDbPort stockWarehouseDbPort;


    @Override
    public MercadonaPage<Store> getAll(StoreQuery query) {
        var stores = storeDbPort.getAll(query);
        var storeIds = stores.getContent().stream().map(Store::getStoreId).collect(Collectors.toSet());
        var mapRacks = rackDbPort.getRacksByStores(storeIds);
        stores.getContent().forEach(store -> setRacks(store, mapRacks));
        return stores;
    }

    private void setRacks(Store store, Map<Long, List<Rack>> mapRacks) {
        store.setRacks(mapRacks.get(store.getStoreId()));
    }

    @Override
    public Store get(Long id) {
        var store = getStoreIfExists(id);
        var racks = rackDbPort.getRacksByStore(id);
        store.setRacks(racks);
        return store;
    }

    private Store getStoreIfExists(Long id) {
        return storeDbPort.get(id).orElseThrow(() -> new PruebaTeException(ErrorCode.STORE_DOES_NOT_EXISTS, id));
    }

    @Override
    public void update(Long id, Store store) {
        store.setStoreId(id);
        storeDbPort.save(store);

    }

    @Override
    public void create(Store store) {
        var storeId = storeDbPort.save(store);
        store.getRacks().forEach(rack -> rack.setStoreId(storeId));
        rackDbPort.saveAll(store.getRacks());
        createDefaultWarehouseZone(storeId);
    }

    private void createDefaultWarehouseZone(Long storeId) {
        warehouseZoneDbPort.save(new WarehouseZone(storeId));
    }

    @Override
    public void delete(Long id) {
        deleteRackStocks(id);
        deleteWarehouseStocks(id);
        warehouseZoneDbPort.deleteByStoreId(id);
        rackDbPort.deleteByStoreId(id);
        storeDbPort.delete(id);
    }

    @Override
    public Store getStock(Long id) {
        var store = get(id);
        setWarehouseZones(id, store);
        setWarehouseStock(store.getWarehouseZones());
        setRackStock(store.getRacks());
        return store;
    }

    private void setWarehouseStock(List<WarehouseZone> warehouseZones) {
        var warehouseZoneIds = warehouseZones.stream().map(WarehouseZone::getWarehouseId).collect(Collectors.toSet());
        Map<Long, List<StockWarehouse>> stocks = stockWarehouseDbPort.getStocksByWarehouseIdsAsMap(warehouseZoneIds);
        warehouseZones.forEach(wz -> wz.setStockWarehouses(stocks.get(wz.getWarehouseId())));
    }

    private void setRackStock(List<Rack> racks) {
        var rackIds = racks.stream().map(Rack::getRackId).collect(Collectors.toSet());
        Map<Long, List<StockRack>> stocks = stockRackDbPort.getStocksByRackIdsAsMap(rackIds);
        racks.forEach(rack -> rack.setStockRacks(stocks.get(rack.getRackId())));
    }

    private void setWarehouseZones(Long id, Store store) {
        var warehouseZones = warehouseZoneDbPort.getWarehouseZonesByStore(id);
        store.setWarehouseZones(warehouseZones);
    }

    @Override
    public Store getGaps(Long id) {
        Store store = getStock(id);
        var racksWithoutStock = store.getRacks().stream().filter(Rack::hasNoStock).toList();
        var racksWithStock = store.getRacks().stream().filter(Predicate.not(Rack::hasNoStock)).toList();
        store.setRacks(racksWithoutStock);
        var warehouseReadyToServe = store.getWarehouseZones().stream().filter(warehouseZone ->
                getWarehouseZonesPendingToServe(warehouseZone, racksWithStock)).toList();
        store.setWarehouseZones(warehouseReadyToServe);
        return store;
    }

    @Override
    public String getStockCsv(Long id) {
        Store store = getStock(id);
        CsvProcessor csvProcessor = new CsvProcessor(store);
        return csvProcessor.getCsv();
    }

    private boolean getWarehouseZonesPendingToServe(WarehouseZone warehouseZone, List<Rack> racksWithStock) {
        var rackProducts =
                racksWithStock.stream().map(Rack::getStockRacks).flatMap(Collection::stream).map(StockRack::getProductId).collect(Collectors.toSet());
        var warehouseValidStocksNotServed =
                warehouseZone.getValidStocks().stream().filter(stockWarehouse -> !rackProducts.contains(stockWarehouse.getProductId())).toList();
        warehouseZone.setStockWarehouses(warehouseValidStocksNotServed);
        return !warehouseValidStocksNotServed.isEmpty();
    }


    private void deleteWarehouseStocks(Long storeId) {
        var zones = warehouseZoneDbPort.getWarehouseZonesByStore(storeId);
        var rackIds = zones.stream().map(WarehouseZone::getWarehouseId).collect(Collectors.toSet());
        var rackStocks = stockWarehouseDbPort.getStocksByWarehouseIds(rackIds);
        stockWarehouseDbPort.deleteStocks(rackStocks);
    }

    private void deleteRackStocks(Long storeId) {
        var racks = rackDbPort.getRacksByStore(storeId);
        var rackIds = racks.stream().map(Rack::getRackId).collect(Collectors.toSet());
        var rackStocks = stockRackDbPort.getStocksByRackIds(rackIds);
        stockRackDbPort.deleteStocks(rackStocks);
    }
}
