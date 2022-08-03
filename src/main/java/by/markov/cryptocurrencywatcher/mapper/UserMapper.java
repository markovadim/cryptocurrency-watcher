package by.markov.cryptocurrencywatcher.mapper;

import by.markov.cryptocurrencywatcher.dto.UserDTO;
import by.markov.cryptocurrencywatcher.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(source = "symbolOfCurrency", target = "symbol")
    UserDTO toDTO(User user);
}
