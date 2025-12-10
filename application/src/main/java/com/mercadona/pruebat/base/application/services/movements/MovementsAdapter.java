package com.mercadona.pruebat.base.application.services.movements;

import com.mercadona.pruebat.base.application.ports.driven.RackDbPort;
import com.mercadona.pruebat.base.application.ports.driven.StoreDbPort;
import com.mercadona.pruebat.base.application.ports.driving.MovementsPort;
import com.mercadona.pruebat.base.domain.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementsAdapter implements MovementsPort {

    private final StoreDbPort storeDbPort;


    @Override
    @Transactional
    public void processMovements(List<Movement> movements) {
        movements.forEach(this::processMovement);

    }

    private void processMovement(Movement movement) {

        switch (movement.getType()) {
            case "VE" -> processSelling(movement);
            case "RO" -> processBreakage(movement);
            case "EA" -> processEntry(movement);
            case "RP" -> processReposition(movement);
            case "RA" -> processWarehouseWithdrawal(movement);
        }
    }

    private void processWarehouseWithdrawal(Movement movement) {

    }

    private void processReposition(Movement movement) {

    }

    private void processEntry(Movement movement) {

    }

    private void processBreakage(Movement movement) {

    }

    private void processSelling(Movement movement) {
    }
}
