package me.iguerrero.inventory_service.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import me.iguerrero.inventory_service.entities.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    Boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);

    Optional<Inventory> findBySkuCode(String skuCode);

}
