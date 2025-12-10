package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.application.ports.driving.StoresPort;
import com.mercadona.pruebat.base.driving.controllers.mappers.StoreDtoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StoreControllerTest {

    @InjectMocks
    private StoreController storeController;
    @Mock
    private StoresPort port;
    @Mock
    private StoreDtoMapper mapper;

    @Test
    void deleteStore(){
        storeController.deleteStore(1L);
        verify(port).delete(1L);
    }


}
