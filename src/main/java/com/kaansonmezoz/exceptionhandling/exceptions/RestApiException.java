package com.kaansonmezoz.exceptionhandling.exceptions;


public class RestApiException extends  RuntimeException{
    private ErrorType errorType;

    public RestApiException(ErrorType errorType, String ... exceptionMessageParams){
        super(String.format(errorType.getExceptionTemplateMessage(), exceptionMessageParams));

        this.errorType = errorType;
    }

    public ErrorType getErrorType(){
        return errorType;
    }
}
