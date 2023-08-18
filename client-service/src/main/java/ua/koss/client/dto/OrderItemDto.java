package ua.koss.client.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class OrderItemDto {
    private Long id;
    private DishesDto dish;
    private int quantity;
}
