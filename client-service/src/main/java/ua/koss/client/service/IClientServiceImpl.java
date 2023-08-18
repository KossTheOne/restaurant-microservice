package ua.koss.client.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.koss.client.dto.ClientDto;
import ua.koss.client.entity.Client;
import ua.koss.client.mapper.ClientDtoClientMapper;
import ua.koss.client.repository.IClientDao;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class IClientServiceImpl implements IClientService{
    private IClientDao clientDao;
    private ClientDtoClientMapper mapper;

    public ClientDto findById(Long clientId) {
        Client client = clientDao.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientId));;
        return mapper.sourceToDestination(client);
    }
}
