package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.driven.repositories.RackRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.RackDbMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RackDbAdapterTest {

    @InjectMocks
    private RackDbAdapter rackDbAdapter;

    @Mock
    private RackRepository repository;
    @Mock
    private RackDbMapper dbMapper;


    @Test
    void delete(){
        rackDbAdapter.deleteByStoreId(1L);
        verify(repository).deleteByStoreId(1L);
    }

}
