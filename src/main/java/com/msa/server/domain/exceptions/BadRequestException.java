package com.msa.server.domain.exceptions;

public class BadRequestException extends BaseRuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}
