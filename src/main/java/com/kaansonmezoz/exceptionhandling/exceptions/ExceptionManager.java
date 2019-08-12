package com.kaansonmezoz.exceptionhandling.exceptions;

import com.kaansonmezoz.exceptionhandling.models.responses.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionManager extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ExceptionResponse> handleGeneralException(Exception ex){
        return createExceptionResponse(ex, ErrorType.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = RestApiException.class)
    protected ResponseEntity<ExceptionResponse> handleRestApiException(RestApiException ex){
        return createExceptionResponse(ex, ex.getErrorType());
    }

    private ResponseEntity<ExceptionResponse> createExceptionResponse(Exception ex, ErrorType errorType){
        ExceptionResponse response = new ExceptionResponse(
            errorType.getErrorCode(),
            errorType.name(),
            ex.getClass().getCanonicalName(),
            ex.getMessage()
        );

        return new ResponseEntity<>(response, errorType.getStatus());
    }
}