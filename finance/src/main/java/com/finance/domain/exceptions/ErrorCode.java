package com.finance.domain.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCode {
    /*
     * 400 Bad Request
     */
    ROW_DOES_NOT_EXIST(4000),
    ROW_ALREADY_EXIST(4001),
    TRANSACTION_SLIP_NOT_MATCH(4002),
    DEBIT_CREDIT_NOT_MATCH(4003),

    /*
     * 500 Internal Server Error
     */
    INTERNAL_SERVER(5000);

    private int code;

    ErrorCode(int code){
        this.code = code;
    }
}
