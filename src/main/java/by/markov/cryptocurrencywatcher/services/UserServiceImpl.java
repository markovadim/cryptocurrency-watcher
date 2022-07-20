package by.markov.cryptocurrencywatcher.services;


import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.dao.UserRepository;
import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CoinRepository coinRepository;


    @Override
    public void saveUser(String username, String symbolOfCurrency) throws CoinNotFoundException {
        userRepository.save(User.builder()
                .username(username)
                .symbolOfCurrency(symbolOfCurrency)
                .localDateTime(LocalDateTime.now())
                .priceCurrencyByRegistration(coinRepository.findBySymbol(symbolOfCurrency).orElseThrow(CoinNotFoundException::new).getPriceUsd())
                .build());
    }
}
