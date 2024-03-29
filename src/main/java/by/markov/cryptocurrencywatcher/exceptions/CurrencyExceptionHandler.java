package by.markov.cryptocurrencywatcher.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CurrencyExceptionHandler {

    @ExceptionHandler(CoinNotFoundException.class)
    public ResponseEntity<?> handleCoinException(CoinNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ParseCoinsException.class)
    public ResponseEntity<?> handleParseException(ParseCoinsException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
    }
}
