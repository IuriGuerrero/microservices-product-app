package me.iguerrero.product_service.common.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import me.iguerrero.product_service.entities.Product;

public class ProductRequest {

    @NotBlank(message = "El nombre no puede estar en blanco.")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres.")
    private String name;

    @NotBlank(message = "La descripción no puede estar en blanco.")
    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres.")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser >= 0.01.")
    @Digits(integer = 8, fraction = 2, message = "El precio debe tener hasta 8 dígitos enteros y 2 decimales.")
    private BigDecimal price;

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product toEntity() {
        Product product = new Product();
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        return product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
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
        ProductRequest other = (ProductRequest) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductRequest [name=" + name + ", description=" + description + ", price=" + price + "]";
    }

}
