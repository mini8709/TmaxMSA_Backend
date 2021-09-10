package com.msa.server.application;

import com.msa.server.application.dto.ExampleResponseDto;
import com.msa.server.application.spi.ExamplePort;
import com.msa.server.domain.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ExampleService {

    private final ExamplePort examplePort;

    public ExampleService(ExamplePort examplePort){
        this.examplePort = examplePort;
    }

    @Transactional(readOnly=true)
    public ExampleResponseDto findById(Long id) {

        return this.examplePort.findById(id).orElseThrow(
                () -> new BadRequestException(
                        "Invalid example id"
                )
        );
    }

}
