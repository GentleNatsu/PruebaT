package com.mercadona.pruebat.base.driving.controllers.api;

import com.mercadona.pruebat.base.driving.controllers.models.TicketDto;
import com.mercadona.pruebat.base.driving.controllers.models.pagination.PageResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name="Stores Api", description = "Stores api")
@RequestMapping("/api/v1/ticket")
public interface TicketApi {

    @Operation(summary = "Get ticket")
    @GetMapping
    ResponseEntity<TicketDto> getTicketFromOrder(Integer orderId);


}
