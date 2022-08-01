package by.markov.cryptocurrencywatcher.mapper;


import by.markov.cryptocurrencywatcher.dto.CoinDTO;
import by.markov.cryptocurrencywatcher.entities.Coin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoinMapper {
    CoinDTO toDTO(Coin coin);

    Coin toEntity(CoinDTO coinDTO);

    List<CoinDTO> toCoinDTOList(List<Coin> coins);
}
