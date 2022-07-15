package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import by.markov.cryptocurrencywatcher.services.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrency/api/coins")
@RequiredArgsConstructor
public class CoinRestController {

    private final CoinService coinService;

    @GetMapping
    public List<Coin> findCoins() {
        return coinService.findAll();
    }

    @GetMapping("/id/{id}")
    public Coin findCoinById(@PathVariable Long id) throws CoinNotFoundException {
        return coinService.findCoinById(id);
    }

    @GetMapping("/name/{symbol}")
    public Coin findCoinBySym(@PathVariable String symbol) throws CoinNotFoundException {
        return coinService.findCoinBySymbol(symbol);
    }
}
