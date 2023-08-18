package ua.koss.client.mapper;

import org.mapstruct.Mapper;
import ua.koss.client.dto.OrderItemDto;
import ua.koss.client.entity.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemDtoOrderItemMapper {
    OrderItemDto sourceToDestination(OrderItem source);
    OrderItem destinationToSource(OrderItemDto destination);
}
