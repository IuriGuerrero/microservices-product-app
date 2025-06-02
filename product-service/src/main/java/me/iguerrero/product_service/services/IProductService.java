package me.iguerrero.product_service.services;

import java.util.Set;

import me.iguerrero.product_service.common.dto.ProductRequest;
import me.iguerrero.product_service.common.dto.ProductResponse;

public interface IProductService {

    ProductResponse getProductById(Long id);

    Set<ProductResponse> getAllProducts();
    
    ProductResponse save(ProductRequest productRequest);

    ProductResponse update(ProductRequest productRequest, Long id);

    void deleteById(Long id);

}
