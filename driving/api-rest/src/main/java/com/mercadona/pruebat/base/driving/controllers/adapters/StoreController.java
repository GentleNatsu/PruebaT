package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.application.ports.driving.StoresPort;
import com.mercadona.pruebat.base.driving.controllers.api.StoresApi;
import com.mercadona.pruebat.base.driving.controllers.mappers.StoreDtoMapper;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoWithProducts;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController implements StoresApi {

    private final StoresPort port;
    private final StoreDtoMapper mapper;

    @Override
    @Transactional
    public ResponseEntity<PageResponseDto<StoreDtoWithProducts>> getAll(StoreQueryDto queryDto) {
        var query = mapper.toDomain(queryDto);
        var page = port.getAll(query);
        return ResponseEntity.ok(mapper.toDto(page));
    }

    @Override
    @Transactional
    public ResponseEntity<StoreDtoWithProducts> getById(Long id) {
        var store = port.get(id);
        return ResponseEntity.ok(mapper.toDtoWithProducts(store));
    }

    @Override
    @Transactional
    public ResponseEntity<Void> updateStore(Long id, StoreDto storeDto) {
        port.update(id, mapper.toDomain(storeDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> createStore(StoreDto storeDto) {
        port.create(mapper.toDomain(storeDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteStore(Long id) {
        port.delete(id);
        return ResponseEntity.noContent().build();
    }
}
