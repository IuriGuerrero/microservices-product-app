package me.iguerrero.order_service.controllers;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.iguerrero.order_service.common.dto.ApiResponse;
import me.iguerrero.order_service.common.dto.OrderRequest;
import me.iguerrero.order_service.common.dto.OrderResponse;
import me.iguerrero.order_service.services.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse updateOrder(@Valid @RequestBody OrderRequest orderRequest, @PathVariable Long id) {
        return orderService.updateOrder(orderRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return new ApiResponse(HttpStatus.OK.value(), "Order by ID " + id + " deleted successfully.", LocalDateTime.now());
    }

}
