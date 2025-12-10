package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.application.ports.driving.MovementsPort;
import com.mercadona.pruebat.base.domain.Movement;
import com.mercadona.pruebat.base.driving.controllers.api.MovementsApiPruebaT;
import com.mercadona.pruebat.base.driving.controllers.mappers.MovementDtoMapper;
import com.mercadona.pruebat.base.driving.controllers.models.MovementDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovementsController implements MovementsApiPruebaT {

    private final MovementsPort port;
    private final MovementDtoMapper movementDtoMapper;


    @Override
    public ResponseEntity<Void> processMovements(Long id, MultipartFile file) {

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<?> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(MovementDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withSeparator(';')
                    .build();
           var models = (List<MovementDto>) csvToBean.parse();

            List<Movement> movements = models.stream().map(movementDtoMapper::toDomain).toList();
            port.processMovements(movements);

        return null;
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
