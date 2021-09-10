package com.msa.server.domain.exceptions;

import lombok.Getter;

@Getter
public abstract class BaseRuntimeException extends RuntimeException{

    private final String message;

    public BaseRuntimeException(String message){
        this.message = message;
    }
}
