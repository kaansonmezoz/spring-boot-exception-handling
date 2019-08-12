package com.kaansonmezoz.exceptionhandling.models.responses;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private int errorCode;
    private String errorType;
    private String exceptionClass;
    private String exceptionMessage;

    public ExceptionResponse(int errorCode, String errorType, String exceptionClass,String exceptionMessage) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.exceptionClass = exceptionClass;
        this.exceptionMessage = exceptionMessage;
    }
}
