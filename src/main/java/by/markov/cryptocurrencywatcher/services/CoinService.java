package by.markov.cryptocurrencywatcher.services;

import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoinService {

    List<Coin> findAll();

    Coin findCoinById(Long id) throws CoinNotFoundException;

    Coin findCoinBySymbol(String symbol) throws CoinNotFoundException;
}
