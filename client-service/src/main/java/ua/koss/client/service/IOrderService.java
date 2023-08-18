package ua.koss.client.service;

import ua.koss.client.dto.OrderDto;

import java.util.List;

public interface IOrderService {
    OrderDto getOrderById(Long id);
    List<OrderDto> getOrderList(Long clientId);
    OrderDto createOrder(OrderDto orderToCreate);
    void removeOrder(OrderDto orderToRemove);
}
