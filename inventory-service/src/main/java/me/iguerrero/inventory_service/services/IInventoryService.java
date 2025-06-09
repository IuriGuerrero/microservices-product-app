package me.iguerrero.inventory_service.services;

import me.iguerrero.inventory_service.common.dto.ApiResponse;
import me.iguerrero.inventory_service.common.dto.ItemRequest;
import me.iguerrero.inventory_service.common.dto.ItemResponse;

public interface IInventoryService {

    ApiResponse isInStock(String skuCode, Integer quantity);

    ItemResponse itemStock(String skuCode);

    ItemResponse createInventoryItem(ItemRequest itemRequest);

}
