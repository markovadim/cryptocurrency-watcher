package by.markov.cryptocurrencywatcher.dao;

import by.markov.cryptocurrencywatcher.entities.Coin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoinRepository extends JpaRepository<Coin, Long> {
    Coin findCoinBySymbolContaining(String symbol);
}
