package by.markov.cryptocurrencywatcher.services;


import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;

public interface UserService {
    void saveUser(String username, String symbolOfCurrency) throws CoinNotFoundException;
}
