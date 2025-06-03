package me.iguerrero.order_service.common.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrderRequest {

    @NotBlank(message = "El nº de pedido no puede estar en blanco.")
    @Size(max = 100)
    private String orderNumber;

    @NotBlank(message = "El skuCode no puede estar en blanco.")
    @Size(max = 100)
    private String skuCode;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser >= 0.01.")
    @Digits(integer = 8, fraction = 2, message = "El precio debe tener hasta 8 dígitos enteros y 2 decimales.")
    private BigDecimal price;

    @NotNull(message = "La cantidad es obligatoria.")
    @Min(value = 1, message = "La cantidad mínima es 1.")
    private Integer quantity;

    public OrderRequest() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        result = prime * result + ((skuCode == null) ? 0 : skuCode.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderRequest other = (OrderRequest) obj;
        if (orderNumber == null) {
            if (other.orderNumber != null)
                return false;
        } else if (!orderNumber.equals(other.orderNumber))
            return false;
        if (skuCode == null) {
            if (other.skuCode != null)
                return false;
        } else if (!skuCode.equals(other.skuCode))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        return true;
    }

}
