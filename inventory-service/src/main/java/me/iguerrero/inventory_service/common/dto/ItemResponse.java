package me.iguerrero.inventory_service.common.dto;

public class ItemResponse {

    public String skuCode;
    public Integer quantity;

    public ItemResponse() {
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
