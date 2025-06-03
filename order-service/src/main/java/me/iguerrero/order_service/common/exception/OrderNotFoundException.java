package me.iguerrero.order_service.common.exception;

public class OrderNotFoundException extends ApplicationException {

    public OrderNotFoundException(Long id) {
        super("Order by ID " + id + " was not found.");
    }

}
