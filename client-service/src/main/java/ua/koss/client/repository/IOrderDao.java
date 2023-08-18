package ua.koss.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.koss.client.entity.Order;

import java.util.List;

public interface IOrderDao extends JpaRepository<Order, Long> {
    Order findOrderById(Long id);
    List<Order> findAllByClient_Id(Long id);
}
