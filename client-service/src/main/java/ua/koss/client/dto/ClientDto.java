package ua.koss.client.dto;

import lombok.*;
import ua.koss.client.entity.Order;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClientDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private List<Order> orders;
}
