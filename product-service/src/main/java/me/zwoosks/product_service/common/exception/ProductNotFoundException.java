package me.zwoosks.product_service.common.exception;

public class ProductNotFoundException extends ApplicationException {

    public ProductNotFoundException(Long id) {
        super("Product by ID " + id + " was not found.");
    }

}
