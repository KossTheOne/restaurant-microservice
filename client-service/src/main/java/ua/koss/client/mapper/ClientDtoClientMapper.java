package ua.koss.client.mapper;

import org.mapstruct.Mapper;
import ua.koss.client.dto.ClientDto;
import ua.koss.client.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientDtoClientMapper {
    ClientDto sourceToDestination(Client client);
    Client destinationToSource(ClientDto clientDto);
}
