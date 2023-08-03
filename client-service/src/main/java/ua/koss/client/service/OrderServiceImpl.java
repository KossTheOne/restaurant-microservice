package ua.koss.client.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.koss.client.dto.OrderDto;
import ua.koss.client.entity.Order;
import ua.koss.client.mapper.OrderDtoOrderMapper;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class OrderServiceImpl implements OrderService {

    private final OrderDtoOrderMapper orderMapper;

    private static final Order firstOrder = Order.builder().orderPrice(11.11).orderId(11L).description("Simple hamburger with coke").build();
    private static final Order secondOrder = Order.builder().orderPrice(3.79).orderId(12L).description("Simple free with souse").build();

    @Override
    public OrderDto getOrderById(Long orderId) {
        // TODO: 8/3/2023 update to use real data instead of mocked one
        return orderMapper.sourceToDestination(firstOrder);
    }

    @Override
    public List<OrderDto> getOrderList(Long clientId) {
        // TODO: 8/3/2023 update logic to work with a real data when database will be added
        List<Order> orders = List.of(
                firstOrder,
                secondOrder
        );
        return orders.stream().map(orderMapper::sourceToDestination).toList();
    }

    @Override
    public OrderDto createOrder(OrderDto orderToCreate) {
        // TODO: 8/3/2023 convert DTO to entity, then save to database
        return null;
    }

    @Override
    public void removeOrder(OrderDto orderToRemove) {
        // TODO: 8/3/2023 add logic to remove orders
    }
}
