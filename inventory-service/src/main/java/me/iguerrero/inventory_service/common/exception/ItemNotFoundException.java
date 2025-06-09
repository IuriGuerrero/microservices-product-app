package me.iguerrero.inventory_service.common.exception;

public class ItemNotFoundException extends ApplicationException {

    public ItemNotFoundException(String skuCode) {
        super("Item by skuCode " + skuCode + " was not found.");
    }

}
