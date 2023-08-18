package ua.koss.client.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.koss.client.dto.ClientDto;
import ua.koss.client.dto.OrderDto;
import ua.koss.client.entity.Client;
import ua.koss.client.entity.Order;
import ua.koss.client.mapper.ClientDtoClientMapper;
import ua.koss.client.mapper.OrderDtoOrderMapper;
import ua.koss.client.repository.IOrderDao;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class IOrderServiceImpl implements IOrderService {

    private final OrderDtoOrderMapper orderMapper;
    private final ClientDtoClientMapper clientMapper;
    private final IOrderDao iOrderDao;
    private final IClientService iClientService;

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = iOrderDao.findOrderById(id);
        return orderMapper.sourceToDestination(order);
    }

    @Override
    public List<OrderDto> getOrderList(Long clientId) {
        log.info(String.format("Fetching orders list with %s clientID", clientId));
        List<Order> ordersList = iOrderDao.findAllByClient_Id(clientId);
        return ordersList.stream().map(orderMapper::sourceToDestination).toList();
    }

    @Override
    public OrderDto createOrder(OrderDto orderToCreate) {
        Order orderEntity = orderMapper.destinationToSource(orderToCreate);
        Client client = clientMapper.destinationToSource(iClientService.findById(orderEntity.getClient().getId()));
        orderEntity.setClient(client);
        client.getOrders().add(orderEntity);

        double orderPrice = orderEntity.getOrderItems().stream()
                .mapToDouble(orderItem -> orderItem.getQuantity() * orderItem.getDish().getPrice())
                .sum();
        orderEntity.setOrderPrice(orderPrice);
        Order savedOrder = iOrderDao.save(orderEntity);
        return orderMapper.sourceToDestination(savedOrder);
    }

    @Override
    public void removeOrder(OrderDto orderToRemove) {
        log.info(String.format("Going to remove Order with ID: %s", orderToRemove.getId()));
        iOrderDao.delete(orderMapper.destinationToSource(orderToRemove));
    }
}
