package by.markov.cryptocurrencywatcher.services;

import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.ParseCoinsException;
import by.markov.cryptocurrencywatcher.mapper.CoinMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class SchedulingService {

    private final UserService userService;
    private final CoinService coinService;
    private final CoinMapper coinMapper;
    private final FeignClientService feignClientService;

    private static final double HUNDRED_PERCENT = 100.0;
    private static final double ONE_PERCENT = 1.0;


    @Scheduled(fixedRate = 60000)
    public void parseInfoFromCoinLore() throws ParseCoinsException {
        feignClientService.getCoins().orElseThrow(ParseCoinsException::new)
                .forEach(e -> {
                    e.setTime(LocalDateTime.now());
                    coinService.save(coinMapper.toEntity(e));
                });
        updateActualPricesForUser();
        checkPriceDifference();
    }

    @Transactional
    public void updateActualPricesForUser() {
        List<User> userListWithActualPrices = userService.findAll()
                .stream()
                .peek(e -> e.setActualPrice(coinService.findCoinBySymbol(e.getSymbolOfCurrency()).getPriceUsd()))
                .collect(Collectors.toList());
        userService.saveAll(userListWithActualPrices);
    }

    public void checkPriceDifference() {
        userService.findAll()
                .forEach(e -> {
                    double differencePercent = Math.abs(e.getActualPrice() - e.getPriceCurrencyByRegistration()) * SchedulingService.HUNDRED_PERCENT / e.getPriceCurrencyByRegistration();
                    if (differencePercent > SchedulingService.ONE_PERCENT) {
                        log.warn("Cryptocurrency: {} | Username: {} | Difference: {}%", e.getSymbolOfCurrency().toUpperCase(), e.getUsername(), differencePercent);
                    }
                });
    }
}
