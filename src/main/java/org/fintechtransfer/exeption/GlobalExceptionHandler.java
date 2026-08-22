package org.fintechtransfer.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleApiException(InsufficientFundsException e) {
        return ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .getMessage(e.getMessage())
                .build();
    }
}
