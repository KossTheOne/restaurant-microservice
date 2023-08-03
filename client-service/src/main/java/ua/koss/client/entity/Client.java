package ua.koss.client.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Client {
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String address;
    private List<Order> orders;
}
