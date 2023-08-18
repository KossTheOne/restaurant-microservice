package ua.koss.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.koss.client.entity.Dishes;

public interface IDishesDao extends JpaRepository<Dishes, Long> {
}
