package by.markov.cryptocurrencywatcher.dao;

import by.markov.cryptocurrencywatcher.entities.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findBySymbol(String symbol);
}
