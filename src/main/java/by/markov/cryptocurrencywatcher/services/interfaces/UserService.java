package by.markov.cryptocurrencywatcher.services.interfaces;


import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;

public interface UserService {
    User saveUser(String username, String symbolOfCurrency) throws CoinNotFoundException;
}
