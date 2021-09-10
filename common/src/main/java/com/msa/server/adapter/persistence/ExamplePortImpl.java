package com.msa.server.adapter.persistence;

import com.msa.server.application.dto.ExampleResponseDto;
import com.msa.server.application.spi.ExamplePort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExamplePortImpl implements ExamplePort {
    private final ExampleRepository exampleRepository;

    public ExamplePortImpl(ExampleRepository exampleRepository){
        this.exampleRepository = exampleRepository;
    }

    @Override
    public Optional<ExampleResponseDto> findById(Long id) {

        return this.exampleRepository.findById(id).map(ExampleResponseDto::from);
    }
}
