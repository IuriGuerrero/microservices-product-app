package me.zwoosks.product_service.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.zwoosks.product_service.common.dtos.ProductRequest;
import me.zwoosks.product_service.common.dtos.ProductResponse;
import me.zwoosks.product_service.common.mapper.ProductMapper;
import me.zwoosks.product_service.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Set<ProductResponse> getAllProducts() {
        Set<ProductResponse> products = new HashSet<>();
        productRepository.findAll().forEach(product -> {
            products.add(productMapper.toResponse(product));
        });
        return products;
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        return productMapper.toResponse(productRepository.save(productMapper.toEntity(productRequest)));
    }

}
