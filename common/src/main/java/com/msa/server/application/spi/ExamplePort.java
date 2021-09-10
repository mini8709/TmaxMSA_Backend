package com.msa.server.application.spi;

import com.msa.server.application.dto.ExampleResponseDto;

import java.util.Optional;

public interface ExamplePort {
     Optional<ExampleResponseDto> findById(Long id);
}

