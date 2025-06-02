package me.iguerrero.product_service.common.exception;

public abstract class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }

}
