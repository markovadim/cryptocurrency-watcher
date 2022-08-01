package by.markov.cryptocurrencywatcher.services.implementations;


import by.markov.cryptocurrencywatcher.dao.CoinRepository;
import by.markov.cryptocurrencywatcher.dao.UserRepository;
import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import by.markov.cryptocurrencywatcher.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CoinRepository coinRepository;


    @Override
    public User saveUser(String username, String symbolOfCurrency) throws CoinNotFoundException {
        return userRepository.save(User.builder()
                .username(username)
                .symbolOfCurrency(symbolOfCurrency)
                .localDateTime(LocalDateTime.now())
                .priceCurrencyByRegistration(coinRepository.findBySymbol(symbolOfCurrency).orElseThrow(CoinNotFoundException::new).getPriceUsd())
                .build());
    }
}
