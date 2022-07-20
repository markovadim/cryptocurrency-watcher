package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.exceptions.CoinNotFoundException;
import by.markov.cryptocurrencywatcher.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrency/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestParam String username,
                           @RequestParam String symbol) throws CoinNotFoundException {
        userService.saveUser(username, symbol);
    }
}
