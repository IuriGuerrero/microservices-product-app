package me.iguerrero.inventory_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.iguerrero.inventory_service.common.dto.ApiResponse;
import me.iguerrero.inventory_service.common.dto.ItemRequest;
import me.iguerrero.inventory_service.common.dto.ItemResponse;
import me.iguerrero.inventory_service.services.IInventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private IInventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse isInStock(@Valid @RequestBody ItemRequest skuAndQuantityRequest) {
        return inventoryService.isInStock(
            skuAndQuantityRequest.getSkuCode(),
            skuAndQuantityRequest.getQuantity()
        );
    }

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public ItemResponse itemStock(@PathVariable String skuCode) {
        return inventoryService.itemStock(skuCode);
    }

    @PostMapping
    public ItemResponse createInventory(@Valid @RequestBody ItemRequest itemRequest) {
        return inventoryService.createInventoryItem(itemRequest);
    }

}
