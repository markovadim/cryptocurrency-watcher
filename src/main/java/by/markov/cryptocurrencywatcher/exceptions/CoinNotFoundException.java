package by.markov.cryptocurrencywatcher.exceptions;

public class CoinNotFoundException extends Exception{
    public CoinNotFoundException() {
        super("Coin Not Found.");
    }
}
