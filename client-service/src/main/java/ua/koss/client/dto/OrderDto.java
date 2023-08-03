package ua.koss.client.dto;

import lombok.*;
import ua.koss.client.entity.Client;
import ua.koss.client.entity.Dishes;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderDto {
    Long orderId;
    String description;
    Client client;
    private double orderPrice;
    private Map<Integer, Dishes> orderDetails;
}
