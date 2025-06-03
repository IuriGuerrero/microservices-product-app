package me.iguerrero.order_service.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import me.iguerrero.order_service.common.dto.OrderRequest;
import me.iguerrero.order_service.common.dto.OrderResponse;
import me.iguerrero.order_service.entities.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    // from request DTO to entity
    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderRequest orderRequest);

    // from entity to response DTO
    OrderResponse toResponse(Order order);

}
