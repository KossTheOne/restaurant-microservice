package ua.koss.client.entity;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Order {
    private long orderId;
    private Client client;
    private String description;
    private double orderPrice;
    private Map<Integer, Dishes> orderDetails;
}
