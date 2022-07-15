package by.markov.cryptocurrencywatcher.services;

import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinRepository coinRepository;


    public List<Coin> findAll() {
        return coinRepository.findAll();
    }

    public Coin findCoinById(Long id) throws CoinNotFoundException {
        return coinRepository.findById(id).orElseThrow(CoinNotFoundException::new);
    }

    public Coin findCoinBySymbol(String symbol) {
        return coinRepository.findCoinBySymbolContaining(symbol);
    }

    public void saveAll(List<Coin> coinList) {
        coinRepository.saveAll(coinList);
    }
}
