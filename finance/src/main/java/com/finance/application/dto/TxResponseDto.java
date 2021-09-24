package com.finance.application.dto;

import com.finance.adapter.persistence.Transactions;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TxResponseDto {

    private String txId;
    private String txBriefs;
    private LocalDateTime txDate;
    private int txAmount;

    private TxResponseDto(String txId, String txBriefs, LocalDateTime txDate, int txAmount){
        this.txId = txId;
        this.txBriefs = txBriefs;
        this.txDate = txDate;
        this.txAmount = txAmount;
    }

    public static TxResponseDto from(Transactions transactions){
        return new TxResponseDto(
                transactions.getId(),
                transactions.getTxBriefs(),
                transactions.getTxDate(),
                transactions.getTxAmount()
        );
    }
}
