package by.markov.cryptocurrencywatcher.services.interfaces;


import by.markov.cryptocurrencywatcher.dto.CoinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "cryptoFeignClient", url = "${multiplecoinsURL}")
public interface FeignClientService {
    @GetMapping
    Optional<List<CoinDTO>> getCoins();
}
