package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.dto.CoinDTO;
import by.markov.cryptocurrencywatcher.mapper.CoinMapper;
import by.markov.cryptocurrencywatcher.services.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrency/api/v1/coins")
@RequiredArgsConstructor
public class CoinRestController {

    private final CoinService coinService;
    private final CoinMapper coinMapper;

    @GetMapping
    public ResponseEntity<List<CoinDTO>> findCoins() {
        return new ResponseEntity<>(coinMapper.toCoinDTOList(coinService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoinDTO> findCoinById(@PathVariable Long id) {
        return new ResponseEntity<>(coinMapper.toDTO(coinService.findCoinById(id)), HttpStatus.OK);
    }

    @GetMapping("/name/{symbol}")
    public ResponseEntity<CoinDTO> findCoinBySym(@PathVariable String symbol) {
        return new ResponseEntity<>(coinMapper.toDTO(coinService.findCoinBySymbol(symbol)), HttpStatus.OK);
    }
}
