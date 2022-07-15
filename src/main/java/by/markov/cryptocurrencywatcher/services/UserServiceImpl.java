package by.markov.cryptocurrencywatcher.services;


import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.dao.UserRepository;
import by.markov.cryptocurrencywatcher.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CoinRepository coinRepository;


    @Override
    public void saveUser(String username, String symbolOfCurrency) {
        userRepository.save(User.builder()
                .username(username)
                .symbolOfCurrency(symbolOfCurrency)
                .localDateTime(LocalDateTime.now())
                .priceCurrencyByRegistration(coinRepository.findCoinBySymbolContaining(symbolOfCurrency).getPriceUsd())
                .build());
    }
}
