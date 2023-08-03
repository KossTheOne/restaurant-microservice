package ua.koss.client.service;

import ua.koss.client.dto.OrderDto;
import ua.koss.client.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long orderId);
    List<Order> getOrderList(Long clientId);
    Order createOrder(OrderDto orderToCreate);
    Order removeOrder(OrderDto orderToRemove);
}
