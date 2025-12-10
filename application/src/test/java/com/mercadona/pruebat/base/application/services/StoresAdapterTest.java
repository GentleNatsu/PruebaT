package com.mercadona.pruebat.base.application.services;

import com.mercadona.pruebat.base.application.ports.driven.*;
import com.mercadona.pruebat.base.application.services.stores.StoresAdapter;
import com.mercadona.pruebat.base.domain.stores.Store;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StoresAdapterTest {

    @InjectMocks
    private StoresAdapter storesAdapter;

    @Mock
    private StoreDbPort storeDbPort;
    @Mock
    private RackDbPort rackDbPort;
    @Mock
    private StockRackDbPort stockRackDbPort;
    @Mock
    private WarehouseZoneDbPort warehouseZoneDbPort;
    @Mock
    private StockWarehouseDbPort stockWarehouseDbPort;

    @Test
    void updateLikeAnApproved(){
        Store store = new Store();
        store.setStoreId(1L);
        storesAdapter.update(1L, store);
        verify(storeDbPort).save(store);
    }


}
