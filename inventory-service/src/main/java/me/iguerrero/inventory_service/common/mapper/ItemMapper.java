package me.iguerrero.inventory_service.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import me.iguerrero.inventory_service.common.dto.ItemRequest;
import me.iguerrero.inventory_service.common.dto.ItemResponse;
import me.iguerrero.inventory_service.entities.Inventory;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    // from request DTO to entity
    @Mapping(target = "id", ignore = true)
    Inventory toEntity(ItemRequest itemRequest);

    // from entity to response DTO
    ItemResponse toResponse(Inventory inventory);

}
