package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.entities.User;
import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import by.markov.cryptocurrencywatcher.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrency/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String username,
                                           @RequestParam String symbol) throws CoinNotFoundException {
        return new ResponseEntity<>(userService.saveUser(username, symbol), HttpStatus.OK);
    }
}
