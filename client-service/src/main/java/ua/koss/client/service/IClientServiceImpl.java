package ua.koss.client.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.koss.client.dto.ClientDto;
import ua.koss.client.entity.Client;
import ua.koss.client.mapper.ClientDtoClientMapper;
import ua.koss.client.repository.IClientDao;

@Log4j2
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class IClientServiceImpl implements IClientService{
    private IClientDao clientDao;
    private ClientDtoClientMapper mapper;

    public ClientDto findById(Long clientId) {
        log.info(String.format("Fetching client with %s clientID", clientId));
        Client client = clientDao.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientId));
        return mapper.sourceToDestination(client);
    }
}
