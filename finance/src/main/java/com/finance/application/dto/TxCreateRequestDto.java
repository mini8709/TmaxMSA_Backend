package com.finance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TxCreateRequestDto {

    private String txBriefs;
    private int txAmount;

}
