package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.racks.Rack;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RackDbPort {

    List<Rack> getRacksByStore(Long id);

    Map<Long, List<Rack>> getRacksByStores(Set<Long> ids);

    void deleteByStoreId(Long id);

    void saveAll(List<Rack> vehicles);
}
