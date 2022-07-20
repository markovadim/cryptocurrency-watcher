package by.markov.cryptocurrencywatcher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CurrencyExceptionHandler {

    @ExceptionHandler(CoinNotFoundException.class)
    public ResponseEntity<?> handleCoinException(CoinNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ParseCoinsException.class)
    public ResponseEntity<?> handleParseException(ParseCoinsException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
    }
}
