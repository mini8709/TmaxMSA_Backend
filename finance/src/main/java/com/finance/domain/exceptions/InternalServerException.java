package com.finance.domain.exceptions;

public class InternalServerException extends BaseRuntimeException {
    public InternalServerException(ErrorCode errorCode, String message){

        super(errorCode, message);
    }
}
