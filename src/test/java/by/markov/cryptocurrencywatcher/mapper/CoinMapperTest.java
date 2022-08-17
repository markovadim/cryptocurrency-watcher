package by.markov.cryptocurrencywatcher.mapper;

import by.markov.cryptocurrencywatcher.dto.CoinDTO;
import by.markov.cryptocurrencywatcher.entities.Coin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoinMapperTest {

    @Autowired
    private CoinMapper coinMapper;

    @Test
    void parseCoinToDTO() {
        Coin coin = new Coin(90, "BTC", "Bitcoin", 24100.00, LocalDateTime.now());
        CoinDTO coinDTO = coinMapper.toDTO(coin);
        assertAll(
                () -> assertEquals(coinDTO.getSymbol(), coin.getSymbol()),
                () -> assertEquals("Bitcoin", coinMapper.toEntity(coinDTO).getName())
        );
    }
}