package com.kaansonmezoz.exceptionhandling.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "Ooops ! Something went wrong"),

    USERNAME_IS_NOT_VALID(100, HttpStatus.BAD_REQUEST, "%S name is not a valid username. Please check your username"),
    USERNAME_EXISTS(101, HttpStatus.CONFLICT, "%s is already exist. Try with different username"),
    USER_NOT_FOUND(102, HttpStatus.NOT_FOUND, "User with %s username is not exist"),
    USER_TOKEN_IS_NOT_VALID(103, HttpStatus.UNAUTHORIZED, "Unauthorized !"),
    USER_IS_BANNED(104, HttpStatus.FORBIDDEN, "User with the username %s has been banned !");

    ErrorType(int errorCode, HttpStatus status, String exceptionTemplateMessage) {
        this.errorCode = errorCode;
        this.status = status;
        this.exceptionTemplateMessage = exceptionTemplateMessage;
    }

    private int errorCode;
    private HttpStatus status;
    private String exceptionTemplateMessage;

    public void throwException(String ... exceptionMessageParams){
        throw new RestApiException(this, exceptionMessageParams);
    }

}
