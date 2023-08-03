package ua.koss.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DishesDto {
    private Long id;
    private String name;
    private double price;
    private Set<OrderItemDto> orderItems = new HashSet<>();
}
