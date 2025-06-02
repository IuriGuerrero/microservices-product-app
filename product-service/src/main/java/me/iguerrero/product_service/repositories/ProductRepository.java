package me.iguerrero.product_service.repositories;

import org.springframework.data.repository.CrudRepository;

import me.iguerrero.product_service.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
