package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.ports.driving.StoresPort;
import com.mercadona.pruebat.base.driving.controllers.api.StoresApiPruebaTe;
import com.mercadona.pruebat.base.driving.controllers.mappers.StoreDtoMapper;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDto;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoExtended;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreDtoUpdate;
import com.mercadona.pruebat.base.driving.controllers.models.store.StoreQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class StoreController implements StoresApiPruebaTe {

    private final StoresPort port;
    private final StoreDtoMapper mapper;


    @Override
    @Transactional
    public ResponseEntity<PageResponseDto<StoreDto>> getAll(StoreQueryDto queryDto) {
        var query = mapper.toDomain(queryDto);
        var page = port.getAll(query);
        return ResponseEntity.ok(mapper.toDto(page));
    }

    @Override
    @Transactional
    public ResponseEntity<StoreDto> getById(Long id) {
        var store = port.get(id);
        return ResponseEntity.ok(mapper.toDtoWithRacks(store));
    }

    @Override
    @Transactional
    public ResponseEntity<Void> updateStore(Long id, StoreDtoUpdate storeDto) {
        port.update(id, mapper.toDomainUpdate(storeDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> createStore(StoreDto storeDto) {
        port.create(mapper.toDomainCreate(storeDto));
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteStore(Long id) {
        port.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<StoreDtoExtended> getStock(Long id) {
        var store = port.getStock(id);
        return ResponseEntity.ok(mapper.toDtoWithStocks(store));
    }

    @Override
    @Transactional
    public ResponseEntity<StoreDtoExtended> getGaps(Long id) {
        var store = port.getGaps(id);
        return ResponseEntity.ok(mapper.toDtoWithStocks(store));
    }

    @Override
    @Transactional
    public ResponseEntity<byte[]> getStockCsv(Long id) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/vnd.ms-excel");
        responseHeaders.add("Content-Disposition", "attachment; filename=stock.csv");

        String data = port.getStockCsv(id);
        try {
            return new ResponseEntity<>(data.getBytes("ISO8859-15"), responseHeaders, HttpStatus.OK);
        } catch (UnsupportedEncodingException exception) {
            throw new PruebaTeException(ErrorCode.PROVETA_ERROR);

        }
    }
}
