package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrency/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestParam String username,
                           @RequestParam String symbol) {
        userService.saveUser(username, symbol);
    }
}
