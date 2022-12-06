package by.markov.cryptocurrencywatcher.services;


import by.markov.cryptocurrencywatcher.dao.UserRepository;
import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CoinService coinService;


    public User saveUser(String username, String symbolOfCurrency) throws CoinNotFoundException {
        return userRepository.save(User.builder()
                .username(username)
                .symbolOfCurrency(symbolOfCurrency)
                .localDateTime(LocalDateTime.now())
                .priceCurrencyByRegistration(coinService.findCoinBySymbol(symbolOfCurrency).getPriceUsd())
                .build());
    }

    public void saveAll(List<User> userList) {
        userRepository.saveAll(userList);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
