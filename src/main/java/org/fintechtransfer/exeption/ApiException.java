package org.fintechtransfer.exeption;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
