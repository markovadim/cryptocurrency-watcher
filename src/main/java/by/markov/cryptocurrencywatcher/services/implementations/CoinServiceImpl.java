package by.markov.cryptocurrencywatcher.services.implementations;

import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import by.markov.cryptocurrencywatcher.services.interfaces.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CoinServiceImpl implements CoinService {

    private final CoinRepository coinRepository;

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
