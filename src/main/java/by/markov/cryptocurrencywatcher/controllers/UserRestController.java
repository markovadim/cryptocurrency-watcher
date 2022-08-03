package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.dto.UserDTO;
import by.markov.cryptocurrencywatcher.mapper.UserMapper;
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
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestParam String username,
                                              @RequestParam String symbol) {
        return new ResponseEntity<>(userMapper.toDTO(userService.saveUser(username, symbol)), HttpStatus.OK);
    }
}
