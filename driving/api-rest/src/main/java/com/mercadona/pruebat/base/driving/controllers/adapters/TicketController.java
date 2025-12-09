package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.driving.controllers.api.TicketApi;
import com.mercadona.pruebat.base.driving.controllers.models.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController implements TicketApi {

//    private final OrderPort port;
//    private final OrderDtoMapper mapper;


    @Override
    public ResponseEntity<TicketDto> getTicketFromOrder(Integer orderId) {
        return null;
    }
}
