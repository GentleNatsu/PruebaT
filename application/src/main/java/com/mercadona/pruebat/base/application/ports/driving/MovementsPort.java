package com.mercadona.pruebat.base.application.ports.driving;

import com.mercadona.pruebat.base.domain.Movement;

import java.util.List;

public interface MovementsPort {

    void processMovements(List<Movement> movements);
}
