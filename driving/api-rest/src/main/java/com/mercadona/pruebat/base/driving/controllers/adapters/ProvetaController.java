package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.driving.controllers.api.ProvetaApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import static com.mercadona.pruebat.base.application.exception.ErrorCode.PROVETA_ERROR;

@Slf4j
@RestController
@AllArgsConstructor
public class ProvetaController implements ProvetaApi {


    @Override
    public String proveta() {
        throw new PruebaTeException(PROVETA_ERROR);
    }
}
