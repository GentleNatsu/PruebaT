package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.framework.cna.commons.domain.MercadonaPage;
import com.mercadona.framework.cna.lib.repository.builders.MercadonaPageBuilder;
import com.mercadona.pruebat.base.application.ports.driven.StoreDbPort;
import com.mercadona.pruebat.base.domain.stores.Store;
import com.mercadona.pruebat.base.domain.stores.StoreQuery;
import com.mercadona.pruebat.base.driven.repositories.StoreRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.StoreDbMapper;
import com.mercadona.pruebat.base.driven.repositories.models.stores.StoreMO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StoreDbAdapter implements StoreDbPort {

    private final MercadonaPageBuilder mercadonaPageBuilder;
    private final StoreRepository storeRepository;
    private final StoreDbMapper storeDbMapper;

    @Override
    public MercadonaPage<Store> getAll(StoreQuery query) {
        var pageRequest =  mercadonaPageBuilder.builder().page(query.getPage()).pageSize(query.getPageSize()).sort(query.getOrder()).build();
        Page<Store> records = getRecords(query, pageRequest);
        return MercadonaPage.of(records);
    }

    private Page<Store> getRecords(StoreQuery query, Pageable pageRequest) {
        Page<StoreMO> records;
        if (query.getName() != null) {
            records = storeRepository.findByDescriptionContaining(query.getName(), pageRequest);
        } else {
            records = storeRepository.findAll(pageRequest);
        }
        return records.map(storeDbMapper::toDomain);
    }

    @Override
    public Optional<Store> get(Long id) {
        return storeRepository.findById(id).map(storeDbMapper::toDomain);
    }

    @Override
    public Long save(Store store) {
        var storeMO = storeDbMapper.toDb(store);
       return storeRepository.save(storeMO).getStoreId();
    }

    @Override
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
