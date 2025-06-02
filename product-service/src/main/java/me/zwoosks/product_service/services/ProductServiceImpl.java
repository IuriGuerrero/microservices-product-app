package me.zwoosks.product_service.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.zwoosks.product_service.common.dtos.ProductRequest;
import me.zwoosks.product_service.common.dtos.ProductResponse;
import me.zwoosks.product_service.common.exception.ProductNotFoundException;
import me.zwoosks.product_service.common.mapper.ProductMapper;
import me.zwoosks.product_service.entities.Product;
import me.zwoosks.product_service.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id)
                                .map(productMapper::toResponse).orElseThrow(() -> new ProductNotFoundException(id));
        
    }

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

    @Override
    public ProductResponse update(ProductRequest productRequest, Long id) {
        // Search existing product
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        
        // Update fields
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());

        // Save updated product
        Product updatedProduct = productRepository.save(existingProduct);

        // Return ProductResponse DTO
        return productMapper.toResponse(updatedProduct);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.delete(
            productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id))
        );
    }

}
