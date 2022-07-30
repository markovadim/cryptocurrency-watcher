package by.markov.cryptocurrencywatcher.exceptions;

public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException() {
        super("Coin Not Found.");
    }
}
