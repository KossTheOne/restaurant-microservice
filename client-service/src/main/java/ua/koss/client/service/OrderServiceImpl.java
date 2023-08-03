package ua.koss.client.service;

import org.springframework.stereotype.Service;
import ua.koss.client.dto.OrderDto;
import ua.koss.client.entity.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public List<Order> getOrderList(Long clientId) {
        return null;
    }

    @Override
    public Order createOrder(OrderDto orderToCreate) {
        return null;
    }

    @Override
    public Order removeOrder(OrderDto orderToRemove) {
        return null;
    }
}
