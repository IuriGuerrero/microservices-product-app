package me.zwoosks.product_service.services;

import java.util.Set;

import me.zwoosks.product_service.common.dtos.ProductRequest;
import me.zwoosks.product_service.common.dtos.ProductResponse;

public interface IProductService {

    ProductResponse getProductById(Long id);

    Set<ProductResponse> getAllProducts();
    
    ProductResponse save(ProductRequest productRequest);

    ProductResponse update(ProductRequest productRequest, Long id);

    void deleteById(Long id);

}
