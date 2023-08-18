package ua.koss.client.mapper;

import org.mapstruct.Mapper;
import ua.koss.client.dto.OrderDto;
import ua.koss.client.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderDtoOrderMapper {
    OrderDto sourceToDestination(Order source);
    Order destinationToSource(OrderDto destination);
}
