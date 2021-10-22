package com.finance.application;

import com.finance.application.dto.*;
import com.finance.application.spi.SlipPort;
import com.finance.application.spi.TransactionsPort;
import com.finance.domain.enums.DCType;
import com.finance.domain.exceptions.BadRequestException;
import com.finance.domain.exceptions.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SlipService {

    private final SlipPort slipPort;
    private final TransactionsPort transactionsPort;


    @Transactional
    public SlipCreateResponseDto create(SlipCreateRequestDto SlipCreateRequestDto) {

        Optional<TxResponseDto> txResponseDto = this.transactionsPort.findById(SlipCreateRequestDto.getTx_id());

        int sum_credit = SlipCreateRequestDto.getSlipRequestDtoList().stream()
                .filter(s -> s.getDcType() == DCType.CREDIT).map(s -> s.getAmount()).reduce(0, Integer::sum);
        int sum_debit = SlipCreateRequestDto.getSlipRequestDtoList().stream()
                .filter(s -> s.getDcType() == DCType.DEBIT).map(s -> s.getAmount()).reduce(0, Integer::sum);
        int tx_amount = txResponseDto.get().getTxAmount();

        if(sum_credit != sum_debit) {
            throw new BadRequestException(ErrorCode.DEBIT_CREDIT_NOT_MATCH,
                    "Credit & Debit Are Not Matched" + sum_credit + ", " + sum_debit);
        } else if(sum_credit != tx_amount) {
            throw new BadRequestException(ErrorCode.TRANSACTION_SLIP_NOT_MATCH,
                    "Transaction & Slips Are Not Matched" + sum_credit + ", " + tx_amount);
        } else {
            return slipPort.create(SlipCreateRequestDto, txResponseDto);
        }
    }

    public SlipSingleResponseDto findSlipById(String id) {
        return this.slipPort.findById(id).orElseThrow(
                () -> new BadRequestException(ErrorCode.ROW_DOES_NOT_EXIST, "Invalid Slip Id: " + id)
        );

    }

    public List<SlipSingleResponseDto> findSlipByTxId(String id) {

        Optional<TxResponseDto> TxResponseDto = this.transactionsPort.findById(id);

        return this.slipPort.findByTxId(TxResponseDto);
    }
}


