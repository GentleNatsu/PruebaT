package com.mercadona.pruebat.base.domain.racks;

import com.mercadona.pruebat.base.domain.SectionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rack {
    private Long rackId;
    private Integer capacity;
    private SectionType section;
    private Long storeId;

    private List<StockRack> stockRacks;


    public boolean hasNoStock() {
        return stockRacks == null || stockRacks.isEmpty();
    }
}
