package me.zwoosks.product_service.common.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import me.zwoosks.product_service.common.dtos.ProductRequest;
import me.zwoosks.product_service.common.dtos.ProductResponse;
import me.zwoosks.product_service.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // from entity to response DTO
    ProductResponse toResponse(Product product);

    // from entity Set to response DTO Set
    Set<ProductResponse> toResponseSet(Set<Product> products);

    // from request DTO to entity
    @Mapping(target = "id", ignore = true)
    Product toEntity(ProductRequest productRequest);

}
