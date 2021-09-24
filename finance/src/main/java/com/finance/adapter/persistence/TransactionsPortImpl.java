package com.finance.adapter.persistence;

import com.finance.application.dto.TxCreateRequestDto;
import com.finance.application.dto.TxResponseDto;
import com.finance.application.spi.TransactionsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransactionsPortImpl implements TransactionsPort {

    private final TransactionsRepository transactionsRepository;

    @Override
    public TxResponseDto create(TxCreateRequestDto request) {

        Transactions tx = this.transactionsRepository.save(Transactions.of(
                        request.getTxBriefs(), LocalDateTime.now(), request.getTxAmount()));

        return TxResponseDto.from(tx);
    }

    /*
     * TODO: findAll 서비스 구현
     */
    @Override
    public void findAll() {

    }

    @Override
    public Optional<TxResponseDto> findById(String id) {
        return this.transactionsRepository.findById(id).map(TxResponseDto::from);
    }
}
