package com.finance.domain.exceptions;

public class BadRequestException extends BaseRuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}
