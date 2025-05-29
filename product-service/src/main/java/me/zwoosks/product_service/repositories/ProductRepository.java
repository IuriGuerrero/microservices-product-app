package me.zwoosks.product_service.repositories;

import org.springframework.data.repository.CrudRepository;

import me.zwoosks.product_service.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
