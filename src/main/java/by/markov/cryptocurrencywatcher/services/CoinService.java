package by.markov.cryptocurrencywatcher.services;

import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CoinService {

    private final CoinRepository coinRepository;

    public Coin save(Coin coin) {
        return coinRepository.save(coin);
    }

    public List<Coin> findAll() {
        return coinRepository.findAll();
    }

    public Coin findCoinById(Long id) throws CoinNotFoundException {
        return coinRepository.findById(id).orElseThrow(CoinNotFoundException::new);
    }

    public Coin findCoinBySymbol(String symbol) throws CoinNotFoundException {
        return coinRepository.findBySymbol(symbol).orElseThrow(CoinNotFoundException::new);
    }
}
