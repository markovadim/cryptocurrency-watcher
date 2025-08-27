package by.markov.cryptocurrencywatcher.controllers;

import by.markov.cryptocurrencywatcher.services.TextGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final TextGenerator textGenerator;

    @GetMapping("/{length}")
    public String generateText(@PathVariable long length) {
        return TextGenerator.generateRandomText(length);
    }
}
