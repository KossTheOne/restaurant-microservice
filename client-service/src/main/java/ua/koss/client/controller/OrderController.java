package ua.koss.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.koss.client.dto.OrderDto;
import ua.koss.client.entity.Client;
import ua.koss.client.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class OrderController {
    private final OrderService orderService;
    private static final Long TEST_USER_ID = 11L;

    @GetMapping(value = "/{orderId}", produces = "application/json")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable String orderId) {
        Long aLong = Long.parseLong(orderId);
        return ResponseEntity.ok(
                OrderDto.builder()
                        .orderId(aLong)
                        .client(Client.builder().firstName("Semen").build())
                        .description("some order details")
                        .build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderList = orderService.getOrderList(TEST_USER_ID);
        return ResponseEntity.ok(orderList);
    }
}
