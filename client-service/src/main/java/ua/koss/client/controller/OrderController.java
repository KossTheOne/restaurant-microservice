package ua.koss.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.koss.client.dto.OrderDto;
import ua.koss.client.service.IOrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class OrderController {
    private final IOrderService iOrderService;
    private static final Long TEST_USER_ID = 11L;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable String id) {
        Long aLong = Long.parseLong(id);
        return ResponseEntity.ok(iOrderService.getOrderById(aLong));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderList = iOrderService.getOrderList(TEST_USER_ID);
        return ResponseEntity.ok(orderList);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto order = iOrderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
