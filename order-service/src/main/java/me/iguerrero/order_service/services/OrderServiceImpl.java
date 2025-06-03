package me.iguerrero.order_service.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.iguerrero.order_service.common.dto.OrderRequest;
import me.iguerrero.order_service.common.dto.OrderResponse;
import me.iguerrero.order_service.common.exception.OrderNotFoundException;
import me.iguerrero.order_service.common.mapper.OrderMapper;
import me.iguerrero.order_service.entities.Order;
import me.iguerrero.order_service.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id)
                                .map(orderMapper::toResponse).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public Set<OrderResponse> getAllOrders() {
        Set<OrderResponse> orders = new HashSet<>();
        orderRepository.findAll().forEach(order -> {
            orders.add(orderMapper.toResponse(order));
        });
        return orders;
    }

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        return orderMapper.toResponse(
            orderRepository.save(orderMapper.toEntity(orderRequest))
        );
    }

    @Override
    public OrderResponse updateOrder(OrderRequest orderRequest, Long id) {
        // Search existing order
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        // Update fields
        existingOrder.setOrderNumber(orderRequest.getOrderNumber());
        existingOrder.setSkuCode(orderRequest.getSkuCode());
        existingOrder.setPrice(orderRequest.getPrice());
        existingOrder.setQuantity(orderRequest.getQuantity());

        // Save updated order
        Order updatedOrder = orderRepository.save(existingOrder);

        // Return as OrderResponse DTO
        return orderMapper.toResponse(updatedOrder);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.delete(
            orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id))
        );
    }

}
