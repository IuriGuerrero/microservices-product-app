package me.iguerrero.order_service.repositories;

import org.springframework.data.repository.CrudRepository;

import me.iguerrero.order_service.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
