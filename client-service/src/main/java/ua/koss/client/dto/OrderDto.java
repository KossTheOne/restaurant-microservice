package ua.koss.client.dto;

import lombok.*;
import ua.koss.client.entity.Client;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderDto {
    private Long id;
    private Client client;
    private String description;
    private double orderPrice;
    private Set<OrderItemDto> orderItems = new HashSet<>();
}
