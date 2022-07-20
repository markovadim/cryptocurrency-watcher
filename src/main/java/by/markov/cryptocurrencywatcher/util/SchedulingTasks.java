package by.markov.cryptocurrencywatcher.util;

import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.dao.UserRepository;
import by.markov.cryptocurrencywatcher.entities.Coin;
import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.ParseCoinsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:application.yaml")
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class SchedulingTasks {

    private final Environment environment;
    private final UserRepository userRepository;
    private final CoinRepository coinRepository;

    private static final double HUNDRED_PERCENT = 100.0;
    private static final double ONE_PERCENT = 1.0;


    @Scheduled(fixedRate = 60000)
    public void parseInfoFromCoinLore() throws ParseCoinsException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Coin>> response = restTemplate.exchange(Objects.requireNonNull(environment.getProperty("multiplecoinsURL")), HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        if (response.getBody() == null) {
            throw new ParseCoinsException();
        }
        response.getBody().forEach(e -> {
            e.setTime(LocalDateTime.now());
            coinRepository.save(e);
        });
    }

    @Scheduled(fixedRate = 60000)
    public void updateActualPricesForUser() {
        List<User> userListWithActualPrices = userRepository.findAll()
                .stream()
                .peek(e -> e.setActualPrice(coinRepository.findBySymbol(e.getSymbolOfCurrency()).get().getPriceUsd()))
                .collect(Collectors.toList());
        userRepository.saveAll(userListWithActualPrices);
    }

    @Scheduled(fixedRate = 60000)
    public void checkPriceDifference() {
        userRepository.findAll()
                .forEach(e -> {
                    double differencePercent = Math.abs(e.getActualPrice() - e.getPriceCurrencyByRegistration()) * SchedulingTasks.HUNDRED_PERCENT / e.getPriceCurrencyByRegistration();
                    if (differencePercent > SchedulingTasks.ONE_PERCENT) {
                        log.warn("Cryptocurrency: " + e.getSymbolOfCurrency() + " | Username: " + e.getUsername() + " | Difference: " + differencePercent + "%");
                    }
                });
    }
}
