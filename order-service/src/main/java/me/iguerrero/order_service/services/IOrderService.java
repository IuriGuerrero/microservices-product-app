package me.iguerrero.order_service.services;

import java.util.Set;

import me.iguerrero.order_service.common.dto.OrderRequest;
import me.iguerrero.order_service.common.dto.OrderResponse;

public interface IOrderService {

    OrderResponse getOrderById(Long id);

    Set<OrderResponse> getAllOrders();

    OrderResponse placeOrder(OrderRequest orderRequest);

    OrderResponse updateOrder(OrderRequest orderRequest, Long id);

    void deleteOrderById(Long id);

}
