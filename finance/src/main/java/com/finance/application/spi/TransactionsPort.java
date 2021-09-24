package com.finance.application.spi;

import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxResponseDto;

import java.util.Optional;

public interface TransactionsPort {

    TxResponseDto create(TxCreateRequestDto request);
    /*
     * TODO : findAll 서비스 구현
     */
    void findAll();
    Optional<TxResponseDto> findById(String id);
}
