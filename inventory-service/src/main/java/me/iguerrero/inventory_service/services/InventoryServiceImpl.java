package me.iguerrero.inventory_service.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import me.iguerrero.inventory_service.common.dto.ApiResponse;
import me.iguerrero.inventory_service.common.dto.ItemRequest;
import me.iguerrero.inventory_service.common.dto.ItemResponse;
import me.iguerrero.inventory_service.common.exception.ConflictException;
import me.iguerrero.inventory_service.common.exception.ItemNotFoundException;
import me.iguerrero.inventory_service.common.mapper.ItemMapper;
import me.iguerrero.inventory_service.entities.Inventory;
import me.iguerrero.inventory_service.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ApiResponse isInStock(String skuCode, Integer quantity) {
        return new ApiResponse(
            HttpStatus.OK,
            Boolean.toString(inventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity)),
            LocalDateTime.now()
        );
    }

    @Override
    public ItemResponse itemStock(String skuCode) {
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
            .orElseThrow(() -> new ItemNotFoundException(skuCode));
        
        return itemMapper.toResponse(inventory);
    }

    @Override
    public ItemResponse createInventoryItem(ItemRequest itemRequest) {
        Optional<Inventory> existing = inventoryRepository.findBySkuCode(itemRequest.getSkuCode());
        if(existing.isPresent()) {
            throw new ConflictException("Item with SKU " + itemRequest.getSkuCode() + " already exists.");
        }
        
        Inventory inventory = itemMapper.toEntity(itemRequest);
        return itemMapper.toResponse(inventoryRepository.save(inventory));
    }

}
