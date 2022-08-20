package by.markov.cryptocurrencywatcher.services.implementations;

import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoinServiceImplTest {

    @Mock
    private CoinRepository coinRepository;

    @Test
    void findAll() {

        when(coinRepository.findAll()).thenReturn(List.of(
                new Coin(90L, "BTC", "Bitcoin", 24000.00, LocalDateTime.now()),
                new Coin(80L, "ETH", "Ethereum", 1500.00, LocalDateTime.now()),
                new Coin(90L, "SOL", "Solana", 34.00, LocalDateTime.now())
        ));
        assertAll(
                () -> assertEquals("Bitcoin", coinRepository.findAll().get(0).getName()),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> coinRepository.findAll().get(3))
        );
    }

    @Test
    void findCoinById() {
        when(coinRepository.findById(80L)).thenReturn(java.util.Optional.of(new Coin(80L, "ETH", "Ethereum", 1500.00, LocalDateTime.now())));
        assertEquals(1500.0, coinRepository.findById(80L).orElseThrow().getPriceUsd());
    }

    @Test
    void findCoinBySymbol() {
        when(coinRepository.findBySymbol("BTC")).thenReturn(java.util.Optional.of(new Coin(90L, "BTC", "Bitcoin", 24000.00, LocalDateTime.now())));
        assertEquals(90L, coinRepository.findBySymbol("BTC").orElseThrow().getIdCoin());
    }
}