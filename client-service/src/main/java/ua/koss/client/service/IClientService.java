package ua.koss.client.service;

import ua.koss.client.dto.ClientDto;

public interface IClientService {
    ClientDto findById(Long clientId);
}
