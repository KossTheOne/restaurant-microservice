package ua.koss.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.koss.client.entity.Client;

public interface IClientDao extends JpaRepository<Client, Long> {
    Client findClientById(Long clientId);
}
