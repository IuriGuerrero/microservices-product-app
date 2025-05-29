package me.zwoosks.product_service.services;

import java.util.Set;

import me.zwoosks.product_service.common.dtos.ProductRequest;
import me.zwoosks.product_service.common.dtos.ProductResponse;

public interface IProductService {

    Set<ProductResponse> getAllProducts();
    
    ProductResponse save(ProductRequest productRequest);

}
