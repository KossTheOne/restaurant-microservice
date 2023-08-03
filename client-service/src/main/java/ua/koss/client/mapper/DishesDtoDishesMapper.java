package ua.koss.client.mapper;

import org.mapstruct.Mapper;
import ua.koss.client.dto.DishesDto;
import ua.koss.client.entity.Dishes;

@Mapper(componentModel = "spring")
public interface DishesDtoDishesMapper {
    DishesDto sourceToDestination(Dishes source);
    Dishes destinationToSource(DishesDto destination);

}
