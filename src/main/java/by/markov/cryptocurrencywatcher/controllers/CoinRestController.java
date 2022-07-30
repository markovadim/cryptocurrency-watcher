package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.services.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrency/api")
@RequiredArgsConstructor
public class CoinRestController {

    private final CoinService coinService;

    @GetMapping("/coins")
    public ResponseEntity<List<Coin>> findCoins() {
        return new ResponseEntity<>(coinService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/coin/id/{id}")
    public ResponseEntity<Coin> findCoinById(@PathVariable Long id) {
        return new ResponseEntity<>(coinService.findCoinById(id), HttpStatus.OK);
    }

    @GetMapping("/coin/name/{symbol}")
    public ResponseEntity<Coin> findCoinBySym(@PathVariable String symbol) {
        return new ResponseEntity<>(coinService.findCoinBySymbol(symbol), HttpStatus.OK);
    }
}
