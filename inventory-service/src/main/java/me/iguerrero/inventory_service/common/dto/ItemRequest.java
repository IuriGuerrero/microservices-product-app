package me.iguerrero.inventory_service.common.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ItemRequest {

    @NotBlank(message = "El skuCode no puede estar en blanco.")
    @Size(max = 100)
    private String skuCode;

    @NotNull(message = "La cantidad es obligatoria.")
    @Min(value = 0, message = "La cantidad mínima es 0.")
    private Integer quantity;

    public ItemRequest() {
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
